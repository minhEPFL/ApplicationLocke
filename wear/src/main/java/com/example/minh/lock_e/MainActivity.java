package com.example.minh.lock_e;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity implements View.OnClickListener {

    private TextView mTextView;

    @Override
    public void onClick(View view){


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        Button buttonshare = findViewById(R.id.button);
        buttonshare.setOnClickListener(this);
        // Enables Always-on
        setAmbientEnabled();
    }

    public void unlock(View view) {
    }
}
