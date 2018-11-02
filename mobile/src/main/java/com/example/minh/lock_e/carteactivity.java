package com.example.minh.lock_e;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class carteactivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteactivity);

        Button Localiser= (Button) findViewById(R.id.Locate);
        Localiser.setOnClickListener((View.OnClickListener)this);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.Locate) {
            Intent i = new Intent(carteactivity.this,MainActivity.class);
            carteactivity.this.startActivity(i);
        }
    }
}
