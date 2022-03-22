package com.example.qrcodeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qrcodeapp.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerate extends Activity
{
    ImageView iv;
    QRCodeWriter writer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generate);

        iv = findViewById(R.id.iv);

        Intent ii = getIntent();
        String code = ii.getStringExtra("code");

        writer = new QRCodeWriter();

        try
        {
            BitMatrix bm = writer.encode(code, BarcodeFormat.QR_CODE,512,512);

            Bitmap bmp = Bitmap.createBitmap(512,512,Bitmap.Config.RGB_565);

            for(int r=0;r<512;r++)
            {
                for(int c=0;c<512;c++)
                {
                    if(bm.get(r,c)==false)
                    {
                        bmp.setPixel(r,c, Color.BLACK);
                    }
                    else
                    {
                        bmp.setPixel(r,c,Color.WHITE);
                    }
                }
            }

            iv.setImageBitmap(bmp);

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "ERROR "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}