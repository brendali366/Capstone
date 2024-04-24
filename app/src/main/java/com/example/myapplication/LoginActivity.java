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

public class LoginActivity extends AppCompatActivity {
    EditText inputEmailLogin;
    EditText inputPasswordLogin;
    Button loginbtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmailLogin = findViewById(R.id.inputEmailLogin);
        inputPasswordLogin = findViewById(R.id.inputPasswordLogin);
        loginbtn = findViewById(R.id.loginbtn);

        mAuth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(view ->{
            loginUser();
        });
    }

    private void loginUser(){
        String email = inputEmailLogin.getText().toString();
        String password = inputPasswordLogin.getText().toString();
        //String username = inputUsername.getText().toString();

        if(TextUtils.isEmpty(email)){
            inputEmailLogin.setError("Email input incorrectly");
            inputEmailLogin.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            inputPasswordLogin.setError("Password input incorrectly");
            inputPasswordLogin.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}