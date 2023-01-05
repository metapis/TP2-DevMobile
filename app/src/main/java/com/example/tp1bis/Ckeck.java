package com.example.tp1bis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ckeck extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ckeck);

        Intent intent = getIntent();
        int challenge1 = intent.getIntExtra("challenge1", 0);
        int challenge2 = intent.getIntExtra("challenge2", 0);

        TextView textView3 = findViewById(R.id.textView6);
        textView3.setText(String.valueOf(challenge1));
        TextView textView4 = findViewById(R.id.textView7);
        textView4.setText(String.valueOf(challenge2));

        Button cancelButton = findViewById(R.id.button4);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Opération annulée", Toast.LENGTH_SHORT).show();
            }
        });

        Button okButton = findViewById(R.id.button5);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.sommeText);
                String value = editText.getText().toString();

                // Renvoie la valeur à l'activité principale
                Intent resultIntent = new Intent(Ckeck.this, MainActivity.class);

                resultIntent.putExtra("value", value);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }}