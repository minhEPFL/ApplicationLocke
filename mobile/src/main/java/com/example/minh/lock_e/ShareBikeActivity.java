package com.example.minh.lock_e;
import android.Manifest;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.LENGTH_LONG;

public class ShareBikeActivity extends MenuActivity implements OnClickListener {
    EditText Num;
    EditText Nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharebike);
        Button buttonPartage = findViewById((R.id.buttonshare));
        buttonPartage.setOnClickListener(this);
        Num = this.findViewById(R.id.numberfriend);
        Nom = this.findViewById(R.id.nom);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.buttonshare) {
            SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) { ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1); }
                String number = Num.getText().toString();
                String nom= Nom.getText().toString();

              if(pref.contains("listeamis")){
                  String [] test=pref.getString("listeamis", "").split(",");
                  Boolean alreadyin = false;
                  for (int i=0; i<test.length; i++){
                      if (test[i].equals(Nom)){
                          alreadyin=true;
                      }
                  }
                  if(!alreadyin){

                      edit.putString("listenum", pref.getString("listenum", "").concat(",".concat(number)));
                      edit.putString("listeamis", pref.getString("listeamis", "").concat(",".concat(nom)));
                      edit.putString("listeautor", pref.getString("listeautor", "").concat("1"));
                      edit.apply();
                  }
                  else if(test.length>=5){
                      Toast.makeText(this, "nombre maximum d'amis atteint", LENGTH_LONG);
                  }
                  else{
                      Toast.makeText(this, "ami déja dans la liste", LENGTH_LONG);
                  }
              }
              else{
                  edit.putString("listenum", number);
                  edit.putString("listeamis", nom);
                  edit.putString("listeautor", "1");
                  edit.apply();
              }
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, "Nous vous invitons à télécharger l'application Lock-E", null, null);
            smsManager.sendTextMessage("0041786571605", null, "add".concat(number), null, null);
        }
    }
}