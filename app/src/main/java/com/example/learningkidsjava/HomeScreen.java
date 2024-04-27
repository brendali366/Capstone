package com.example.learningkidsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);


        // Methods to make buttons move to different screens

        //Creating Buttons to Move Between Screens
        Button ContactButton = findViewById(R.id.contactbutton);
        Button LeaderboardButton = findViewById(R.id.leaderboardbutton);
        Button SettingsButton = findViewById(R.id.settingsbutton);
        Button StoryButton = findViewById(R.id.storybutton);
        //Placeholder for logoutbutton, idk if you need it though
        //Button LogoutButton = findViewById(R.id.logoutbutton)

        //On Click Listeners to move between activities
        ContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ContactBookTest.class);
                startActivity(intent);
            }
        });

        LeaderboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, LeaderboardTest.class);
                startActivity(intent);
            }
        });

        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, SettingsTest.class);
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


        //Placeholder for logout button, idk if you need it though
//        LogoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeScreen.this, SettingsTest.class);
//                startActivity(intent);
//            }
//        });

    }

}