package com.example.minh.lock_e;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.widget.Toast;
import static android.content.Context.MODE_PRIVATE;

public class SMSReceiver extends BroadcastReceiver {
    private final String   ACTION_RECEIVE_SMS  = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences pref = context.getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        if (intent.getAction().equals(ACTION_RECEIVE_SMS)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                final SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                if (messages.length > -1) {
                    final String messageBody = messages[0].getMessageBody();
                    final String phoneNumber = messages[0].getDisplayOriginatingAddress();

                    if(messageBody.substring(0,3).equals("pos")){
                        edit.putString("derniereposition", messageBody.substring(3,messageBody.length())).apply();
                        abortBroadcast();
                    }
                    if(messageBody.substring(0,3).equals("val")){
                        Toast.makeText(context, "Opération effectuée avec succès", Toast.LENGTH_LONG).show();
                        abortBroadcast();
                    }
                    if(messageBody.substring(0,3).equals("vol")){
                        Toast.makeText(context, "Suspicious activity detected", Toast.LENGTH_LONG).show();
                        abortBroadcast();
                    }
                    if(messageBody.substring(0,3).equals("fri")){
                        Toast.makeText(context, "mettre a jour la liste", Toast.LENGTH_LONG).show();
                        abortBroadcast();
                    }
                }
            }
        }
    }
}