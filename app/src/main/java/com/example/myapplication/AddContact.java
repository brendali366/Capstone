package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {

    private EditText nameEdt;
    private Button ContactSaveButtonBtn;

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Initializing views
        nameEdt = findViewById(R.id.Name);
        ContactSaveButtonBtn = findViewById(R.id.ContactSaveButton);

        // Initializing Firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        usersRef = firebaseDatabase.getReference("users");


        ContactSaveButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(AddContact.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    String uid = mAuth.getCurrentUser().getUid();
                    String email = mAuth.getCurrentUser().getEmail(); // Get current user's email
                    usersRef.child(uid).setValue(new UserInfo(email, name))
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(AddContact.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddContact.this, ContactBookScreen.class);
                                startActivity(intent);
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(AddContact.this, "Registration Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                }
            }
        });
    }
}