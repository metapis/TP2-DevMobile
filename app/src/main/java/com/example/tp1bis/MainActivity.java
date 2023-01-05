package com.example.tp1bis;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tp1bis.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int CALL_Perm = 1;

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.CALL_PHONE}, CALL_Perm);

        ImageButton btn5 = (ImageButton) findViewById(R.id.imageButton4);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalIntent = new Intent(MainActivity.this, Login.class);
                startActivity(personalIntent);
            }
        });

        ImageButton btn = (ImageButton) findViewById(R.id.imageButton6);
        final EditText inputText = findViewById(R.id.challenge1text);
        final EditText inputText2 = findViewById(R.id.challenge2text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int challenge1 = Integer.parseInt(inputText.getText().toString());
                int challenge2 = Integer.parseInt(inputText2.getText().toString());
                Intent checkIntent = new Intent(MainActivity.this, Ckeck.class);
                checkIntent.putExtra("challenge1", challenge1);
                checkIntent.putExtra("challenge2", challenge2);
                startActivity(checkIntent);
            }
        });


        ImageButton personalButton = findViewById(R.id.imageButton7);

        personalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalIntent = new Intent(MainActivity.this, ActivityPerso.class);
                startActivity(personalIntent);
            }
        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
                String value = data.getStringExtra("value");
                Log.i("value",value);
                final EditText inputText = findViewById(R.id.challenge1text);
                final EditText inputText2 = findViewById(R.id.challenge2text);
                String number1String = inputText.getText().toString();
                String number2String = inputText2.getText().toString();
                int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);

                if (Integer.parseInt(value) == (number1 + number2)) {
                    final EditText urlEditText = findViewById(R.id.editTextTextPersonName2);
                    String url = urlEditText.getText().toString();
                    if (url.isEmpty()) {
                        url = "https://www.emi.com/";
                    }
                    Uri websiteUri = Uri.parse(url);
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteUri);
                    startActivity(websiteIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Opération annulée", Toast.LENGTH_SHORT).show();
                }
            }
        }



        @Override
        public void onRequestPermissionsResult(int requestCode,
        String[] permissions, int[] grantResults) {
            super.onRequestPermissionsResult(requestCode,
                    permissions, grantResults);
//check the permission type using the requestCode
            int CALL_Perm=1;
            if (requestCode == CALL_Perm) {
//the array is empty if not granted
                if (grantResults.length>0 &&
                        grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {Toast.makeText(this, "GRANTED CALL", Toast.LENGTH_SHORT).show();}
            }
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}