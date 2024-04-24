package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateProfile extends AppCompatActivity {

    private EditText usernameEdt;
    private Button createProfileButtonBtn;

    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference usersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Initializing views
        usernameEdt = findViewById(R.id.username);
        createProfileButtonBtn = findViewById(R.id.createProfileButton);

        // Initializing Firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        usersRef = firebaseDatabase.getReference("users");

        // Checking for empty username input, if not adds to database
        createProfileButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameEdt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(CreateProfile.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    String uid = mAuth.getCurrentUser().getUid();
                    String email = mAuth.getCurrentUser().getEmail(); // Get current user's email
                    usersRef.child(uid).setValue(new UserInfo(email, name))
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(CreateProfile.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(CreateProfile.this, HomeScreen.class);
                                startActivity(intent);
                            })
                            .addOnFailureListener(e -> {
                                Toast.makeText(CreateProfile.this, "Registration Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            });
                }
            }
        });
    }
}





        /*
        createProfileButtonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameEdt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(CreateProfile.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    addDatatoFirebase(name);
                }
            }
        });
    }

    private void addDatatoFirebase(String name) {

        UserInfo userInfoObject = new UserInfo(name);

         */

       /* databaseReference.setValue(userInfoObject, new DatabaseReference.CompletionListener() {

           //if no error takes user to home screen
            @Override
            public void onComplete(@NonNull DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null) {
                    Toast.makeText(CreateProfile.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateProfile.this, HomeScreen.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(CreateProfile.this, "Fail to add data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }*/
