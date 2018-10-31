package com.example.minh.lock_e;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class sharebike extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharebike);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        Button buttonRetour = (Button) findViewById((R.id.buttonretour));
        buttonRetour.setOnClickListener((OnClickListener)this);

    }


    public void onClick(View view) {
        if (view.getId() == R.id.buttonretour) {
            //setContentView(R.layout.activity_sharebike);
            Toast.makeText(this, "retour", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }


    }
}
