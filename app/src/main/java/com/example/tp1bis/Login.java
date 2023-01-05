package com.example.tp1bis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.button3);
        final EditText loginEditText = findViewById(R.id.editTextTextPersonName4);
        final EditText passwordEditText = findViewById(R.id.editTextTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (login.equals("TPandINFO") && password.equals("secret")) {
                    ImageButton btn5 = (ImageButton) findViewById(R.id.imageButton4);
                    final EditText phoneNumberEditText = findViewById(R.id.editTextTextPersonName);
                    btn5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String phoneNumber = phoneNumberEditText.getText().toString();
                            Uri phoneUri = Uri.parse("tel:" + phoneNumber);
                            Intent callIntent = new Intent(Intent.ACTION_CALL, phoneUri);
                            startActivity(callIntent);
                        }
                    });
                } else {
                   finish();
                }
            }
        });

        Button quitButton = findViewById(R.id.button2);

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}