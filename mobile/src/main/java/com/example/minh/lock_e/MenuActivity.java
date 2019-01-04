package com.example.minh.lock_e;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        String chaineamis=getSharedPreferences("preferences", 0).getString("listeamis", "nobody");
        String [] listefriends= chaineamis.split(",");

        for (int i=0;i<listefriends.length;i++) {
            if(listefriends[i]=="noboby"){
            menu.add(listefriends[i]);
            MenuItem a = menu.getItem(menu.size() - 1);
            a.setCheckable(true);
            char b= getSharedPreferences("preferences", MODE_PRIVATE).getString("listeautor", "error").charAt(i);
            a.setChecked(b=='1');
        }}
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getTitle() != null) {
            String nom = item.getTitle().toString();

            int position = -1;
            String[] liste = getSharedPreferences("preferences", 0).getString("listeamis", "error").split(",");
            String c = getSharedPreferences("preferences", 0).getString("listeautor", "error");

            //get the position
            for (int i = 0; i < liste.length; i++) {
                if (liste[i].equals(nom)) {
                    position = i;
                }
            }

            switch (item.getItemId()) {
                case R.id.option: {
                    Intent Options = new Intent(MenuActivity.this, options.class);
                    startActivity(Options);
                    return true;
                }
                default: {
                    if (item.isChecked()) {
                        if (position != -1 & position != 0) {
                            getSharedPreferences("preferences", 0).edit().putString("listeautor", c.substring(0, position).concat("0").concat(c.substring(position + 1))).apply();
                        }
                        if (position == 0) {
                            getSharedPreferences("preferences", 0).edit().putString("listeautor", "0".concat(c.substring(1))).apply();
                        }
                        item.setChecked(false);
                        return true;
                    } else {
                        if (position != -1 & position != 0) {
                            getSharedPreferences("preferences", 0).edit().putString("listeautor", c.substring(0, position).concat("1").concat(c.substring(position + 1))).apply();
                        }
                        if (position == 0) {
                            getSharedPreferences("preferences", 0).edit().putString("listeautor", "1".concat(c.substring(1))).apply();
                        }
                        item.setChecked(true);
                        return true;
                    }
                }
            }

        }
    else{
            this.finish();
            return true;
        }
    }}