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
        Button link = (Button) findViewById(R.id.linkbutton);
        link.setOnClickListener(this);
    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onPause(){
        super.onPause();

    }


    public void onClick (View view){
        if(view.getId()==R.id.button3){
            Intent i = new Intent(MainActivity.this, ShareBikeActivity.class);
            MainActivity.this.startActivity(i);
        }
        if(view.getId()==R.id.button4){
            Intent i = new Intent(MainActivity.this, MapActivity.class);
            MainActivity.this.startActivity(i);
        }
        if(view.getId()==R.id.linkbutton){
            Intent i = new Intent(MainActivity.this, LinkLockActivity.class);
            MainActivity.this.startActivity(i);

        }

}
}
