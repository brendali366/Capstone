package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeScreen extends AppCompatActivity {

    Button LogoutButton;
    Button ContactButton;
    Button LeaderboardButton;
    Button StoryButton;
    Button SettingsButton;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //initializing the buttons
         LogoutButton = findViewById(R.id.logoutbtn);
         ContactButton = findViewById(R.id.contactbutton);
         LeaderboardButton = findViewById(R.id.leaderboardbutton);
         SettingsButton = findViewById(R.id.settingsbutton);
         StoryButton = findViewById(R.id.storybutton);

        //for firebase
         mAuth = FirebaseAuth.getInstance();

        LogoutButton.setOnClickListener(view->{
            mAuth.signOut();
            Intent intent = new Intent(HomeScreen.this, MainActivity.class);
            startActivity(intent);
        });

        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, SettingsScreen.class);
                startActivity(intent);
            }
        });


        ContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ContactBookScreen.class);
                startActivity(intent);
            }
        });

        /*
        LeaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, LeaderboardTest.class);
                startActivity(intent);
            }
        });



        StoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, StoryGameTest.class);
                startActivity(intent);
            }
        });
        */




    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null){
            Intent intent = new Intent(HomeScreen.this, MainActivity.class);
            startActivity(intent);
        }
    }
}

/*


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // button for logout and initializing our button.
        Button logoutBtn = findViewById(R.id.logoutbtn);

        // adding onclick listener for our logout button.
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is for getting instance
                // for AuthUi and after that calling a
                // sign out method from FIrebase.
                AuthUI.getInstance()
                        .signOut(HomeScreen.this)

                        // after sign out is executed we are redirecting
                        // our user to MainActivity where our login flow is being displayed.
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {

                                // below method is used after logout from device.
                                Toast.makeText(HomeScreen.this, "User Signed Out", Toast.LENGTH_SHORT).show();

                                // below line is to go to MainActivity via an intent.
                                Intent i = new Intent(HomeScreen.this, MainActivity.class);
                                startActivity(i);
                            }
                        });
            }
        });
    }
 */

