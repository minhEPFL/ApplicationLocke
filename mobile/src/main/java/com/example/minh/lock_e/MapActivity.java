package com.example.minh.lock_e;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MapActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteactivity);

        Button Localiser= (Button) findViewById(R.id.Locate);
        Localiser.setOnClickListener((View.OnClickListener)this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.Locate) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, Ask for permision
                ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1);
            }
            else {
            }
            //codeicipourobtenirlalocalisation
            SmsManager smsManager = SmsManager.getDefault();
            for (int i=1;i<=10;i++){
            smsManager.sendTextMessage("+33659615446", null, "Ceci est un sms envoyé grâce à l'application", null, null);
            }
        }
    }
}