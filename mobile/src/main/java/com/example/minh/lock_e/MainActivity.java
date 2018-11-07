package com.example.minh.lock_e;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  OnClickListener  {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()) {
            case R.id.option: {
                Toast.makeText(getBaseContext(), "vous avez appuyé sur le bouton options", Toast.LENGTH_LONG).show();
                return true;
            }

            case R.id.ami1: {
                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }
            case R.id.ami2: {
                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }
            case R.id.ami3: {

                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }
            case R.id.ami4: {

                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }
            case R.id.ami5: {

                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }
            case R.id.ami6: {

                if (item.isChecked()) {
                    item.setChecked(false);
                    return true;
                } else {
                    item.setChecked(true);
                    return true;
                }
            }

        }


        return super.onOptionsItemSelected(item);
    }

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
