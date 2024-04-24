package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {
    EditText inputEmail;
    EditText inputPassword;

    //EditText inputUsername;
    Button registerbtn;

FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        //inputUsername = findViewById(R.id.inputUsername);
        registerbtn = findViewById(R.id.registerbtn);

        mAuth = FirebaseAuth.getInstance();

        //register button
        registerbtn.setOnClickListener(view ->{
            createUser();
        });

    }

    private void createUser(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        //String username = inputUsername.getText().toString();

        if(TextUtils.isEmpty(email)){
            inputEmail.setError("Email entry cannot be empty");
            inputEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            inputPassword.setError("Password entry cannot be empty");
            inputPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, HomeScreen.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}