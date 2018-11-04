package com.example.minh.lock_e;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button firstbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonshare = (Button) findViewById(R.id.button3);
        buttonshare.setOnClickListener(this);
        Button buttonmap = (Button) findViewById(R.id.button4);
        buttonmap.setOnClickListener(this);
    }

    public void onClick (View view){
        if(view.getId()==R.id.button3){
            Intent i = new Intent(MainActivity.this,SharebikeActivity.class);
            MainActivity.this.startActivity(i);
        }
        if(view.getId()==R.id.button4){
            Intent i = new Intent(MainActivity.this, MapActivity.class);
            MainActivity.this.startActivity(i);
        }
}
}
