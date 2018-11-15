package com.example.minh.lock_e;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private final String Receive = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        String chaineamis=getSharedPreferences("preferences", 0).getString("listeamis", "nobody");
        String [] listefriends= chaineamis.split(",");

        for (int i=0;i<listefriends.length;i++) {
            menu.add(listefriends[i]);
            MenuItem a = menu.getItem(menu.size() - 1);
            a.setCheckable(true);
            char b= getSharedPreferences("preferences", MODE_PRIVATE).getString("listeautor", "error").charAt(i);
            a.setChecked(b=='1');
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        String nom= item.getTitle().toString();
        int position=-1;
        String[] liste=getSharedPreferences("preferences", 0).getString("listeamis", "error").split(",");
        String c = getSharedPreferences("preferences", 0).getString("listeautor", "error");

        //get the position
        for (int i=0;i<liste.length; i++){
            if (liste[i].equals(nom)){position=i;
            }
        }

        switch (item.getItemId()) {
            case R.id.option: {
                Intent Options = new Intent(MenuActivity.this, options.class);
                startActivity(Options);
                return true;
            }
            default : {
                if (item.isChecked()) {
                    if (position!=-1 & position != 0) {
                        getSharedPreferences("preferences", 0).edit().putString("listeautor", c.substring(0, position).concat("0").concat(c.substring(position+1))).apply();
                    }
                    if (position==0){
                        getSharedPreferences("preferences", 0).edit().putString("listeautor","0".concat(c.substring(1))).apply();
                    }
                    item.setChecked(false);
                    return true;
                }
                else {
                    if (position!=-1 & position != 0) {
                        getSharedPreferences("preferences", 0).edit().putString("listeautor",c.substring(0, position).concat("1").concat(c.substring(position+1))).apply();
                        }
                    if (position==0){
                        getSharedPreferences("preferences", 0).edit().putString("listeautor","1".concat(c.substring(1))).apply();
                    }
                    item.setChecked(true);
                    return true;
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(Receive)){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for(int i =0; i<pdus.length;i++){
                    Toast.makeText(context, "tu as recu un message", Toast.LENGTH_LONG).show();

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                            != PackageManager.PERMISSION_GRANTED) {
                        // Permission is not granted, Ask for permision
                        ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1); }

                    //final String messageBody = messages[0].getMessageBody();
                    //final String phoneNumber = messages[0].getDisplayOriginatingAddress();

                    //Toast.makeText(context, "Expediteur : " + phoneNumber, Toast.LENGTH_LONG).show();
                    //Toast.makeText(context, "Message : " + messageBody, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}