package com.example.minh.lock_e;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.button3);
        button1.setOnClickListener((OnClickListener)this);
    }


    public void onClick (View view){
        if(view.getId()==R.id.button3){
            Toast.makeText(this,"coucou", Toast.LENGTH_SHORT).show();
            Intent share = new Intent(MainActivity.this,sharebike.class);
            startActivity(share);

        }
    }

}
