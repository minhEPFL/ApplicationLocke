package com.example.minh.lock_e;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends MenuActivity implements  OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
