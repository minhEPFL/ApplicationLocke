package com.example.minh.lock_e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);
    }

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
}
