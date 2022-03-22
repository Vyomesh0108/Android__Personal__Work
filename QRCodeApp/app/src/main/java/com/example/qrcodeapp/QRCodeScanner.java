package com.example.qrcodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanner extends Activity implements ZXingScannerView.ResultHandler
{
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_scanner);

        scannerView = new ZXingScannerView(getApplicationContext());
        setContentView(scannerView);

        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult)
    {
        Toast.makeText(getApplicationContext(),rawResult.getText(),Toast.LENGTH_LONG).show();
    }
}