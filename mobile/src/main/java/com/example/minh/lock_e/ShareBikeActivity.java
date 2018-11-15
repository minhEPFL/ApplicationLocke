package com.example.minh.lock_e;
import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;


public class ShareBikeActivity extends MenuActivity implements OnClickListener {
    EditText Num;
    EditText Nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharebike);
        Button buttonPartage = (Button) findViewById((R.id.buttonshare));
        buttonPartage.setOnClickListener((OnClickListener)this);
        Num = this.findViewById(R.id.numberfriend);
        Nom = this.findViewById(R.id.nom);
    }

    public void onClick(View view) {
        //Si le bouton Share a été enfoncé
        if (view.getId() == R.id.buttonshare) {
            SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, Ask for permision
                ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1); }

                String number = Num.getText().toString();
                String nom= Nom.getText().toString();

              if(pref.contains("listeamis")){
                  edit.putString("listeamis", pref.getString("listeamis", "").concat(",".concat(nom)));
                  edit.putString("listeautor", pref.getString("listeautor", "").concat("1"));
                  edit.apply();
              }
              else{
                  edit.putString("listeamis", nom);
                  edit.putString("listeautor", "1");
                  edit.apply();
              }
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, "Nous vous invitons à télécharger l'application Lock-E", null, null);
        }
    }
}