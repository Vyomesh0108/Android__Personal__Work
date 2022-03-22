package com.example.qrcodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity
{
    EditText et;
    Button btGen,btScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.etCode);
        btGen = findViewById(R.id.btnCreate);
        btScan = findViewById(R.id.btnScan);

        btGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = et.getText().toString();

                Intent i1 = new Intent(getApplicationContext(),QRCodeGenerate.class);
                i1.putExtra("code",code);
                startActivity(i1);
            }
        });

        btScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(getApplicationContext(),QRCodeScanner.class);
                startActivity(i2);
            }
        });
    }
}