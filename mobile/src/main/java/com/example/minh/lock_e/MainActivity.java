package com.example.minh.lock_e;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Switch;

public class MainActivity extends MenuActivity implements  OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) //on vérifie qu'on a bien les permissions
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, Ask for permision
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) //on vérifie qu'on a bien les permissions
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.READ_SMS}, 1);
        }

        Button buttonshare = findViewById(R.id.button3);
        buttonshare.setOnClickListener(this);
        Button buttonmap = findViewById(R.id.button4);
        buttonmap.setOnClickListener(this);
        Button link = findViewById(R.id.linkbutton);
        link.setOnClickListener(this);
    }

    public void unlock(android.view.View v){

        String number="0041786571605";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, "unl", null, null);

    }

    public void securize(android.view.View v){

        String number="0041786571605";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, "asm", null, null);
    }




    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }

    public void onClick (View view){
        if(view.getId()==R.id.button3){
            Intent i = new Intent(MainActivity.this, ShareBikeActivity.class);
            MainActivity.this.startActivity(i);
        }
        if(view.getId()==R.id.button4){
            Intent i = new Intent(MainActivity.this, MapActivity.class);
            MainActivity.this.startActivity(i);
        }
        if(view.getId()==R.id.linkbutton){
            Intent i = new Intent(MainActivity.this, LinkLockActivity.class);
            MainActivity.this.startActivity(i);
        }
}
}
