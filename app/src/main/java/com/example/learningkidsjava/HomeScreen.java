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


        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, SettingsTest.class);
                startActivity(intent);
            }
        });

        //adding onClickListener
//        contactbtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                AuthUI.getInstance()
//                        .signOut(ContactBookTest.this)
//
//
//            }
//            Intent contactintent = new Intent(this, ContactBookTest.class);
//            startActivity(contactintent);
//        }
    }

}