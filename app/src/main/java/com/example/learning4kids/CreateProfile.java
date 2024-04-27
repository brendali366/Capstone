package com.example.learning4kids;
import com.example.learning4kids.UserInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateProfile extends AppCompatActivity {

    private EditText usernameEdt;
    private Button createProfileButtonBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        // Initializing views
        usernameEdt = findViewById(R.id.username);
        createProfileButtonBtn = findViewById(R.id.createProfileButton);

        // Initializing Firebase
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserInfo");

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

        databaseReference.setValue(userInfoObject, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@NonNull DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null) {
                    Toast.makeText(CreateProfile.this, "Data added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateProfile.this, "Fail to add data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
