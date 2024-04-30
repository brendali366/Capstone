package com.example.myapplication;

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

public class AddContactActivity extends AppCompatActivity {

    String number, address, info;
    Button registerbtn;

    EditText inputNumber;
    EditText inputAddress;
    EditText inputExtraInfo;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showToast(String text) {
        Toast.makeText(AddContactActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}

