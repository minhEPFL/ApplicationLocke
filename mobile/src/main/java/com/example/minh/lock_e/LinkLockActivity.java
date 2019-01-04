package com.example.minh.lock_e;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LinkLockActivity extends MenuActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_lock);

        Button link= findViewById(R.id.connect);
        link.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        EditText numero = findViewById(R.id.editText);
        String num=numero.getText().toString();
        String number="0041786571605";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, "con", null, null);
    }
}
