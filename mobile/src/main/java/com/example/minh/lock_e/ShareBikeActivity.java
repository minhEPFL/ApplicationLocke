package com.example.minh.lock_e;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

public class ShareBikeActivity extends AppCompatActivity implements OnClickListener {
    EditText Edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharebike);
        Button buttonPartage = (Button) findViewById((R.id.buttonshare));
        buttonPartage.setOnClickListener((OnClickListener)this);
        Edit1 = this.findViewById(R.id.numberfriend);


    }

    public void onClick(View view) {
        if (view.getId() == R.id.buttonshare) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, Ask for permision
                ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1);
            }
            else {
            }
            String chaine = Edit1.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(chaine, null, "Ceci est un sms envoyé grâce à l'application", null, null);

            //Intent i = new Intent(ShareBikeActivity.this,MainActivity.class);
            //ShareBikeActivity.this.startActivity(i);
        }
    }
}
