package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class AddContact extends AppCompatActivity {
    String number, address, info;
    Button registerbtn;

    EditText inputNumber;
    EditText inputAddress;
    EditText inputExtraInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        inputNumber = (EditText) findViewById(R.id.inputNumber);
        inputAddress = (EditText) findViewById(R.id.inputAddress);
        inputExtraInfo = (EditText) findViewById(R.id.inputExtraInfo);

        registerbtn = (Button) findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = inputNumber.getText().toString();
                address = inputAddress.getText().toString();
                info = inputExtraInfo.getText().toString();

                showToast(number);
                showToast(address);
                showToast(info);
            }
        });
    }

    private void showToast(String text) {
        Toast.makeText(AddContact.this, text, Toast.LENGTH_SHORT).show();
    }}
