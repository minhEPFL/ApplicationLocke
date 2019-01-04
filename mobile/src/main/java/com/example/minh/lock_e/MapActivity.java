package com.example.minh.lock_e;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class MapActivity extends MenuActivity implements View.OnClickListener, OnMapReadyCallback{
    private Handler myHandler;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteactivity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button Localiser= findViewById(R.id.Locate);
        Localiser.setOnClickListener(this);

        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,1000);
    }

    private Runnable myRunnable = new Runnable() {
        @Override
        public void run()
        {
            SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
            // Code à éxécuter de façon périodique
            String a= pref.getString("derniereposition", "0e0");
            //Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
            String[] b=a.split("e");
            float lat=Float.parseFloat(b[0]);
            float lon=Float.parseFloat(b[1]);
            LatLng lastloc = new LatLng(lat, lon);
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(lastloc).title("Velo"));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(lastloc));
            mMap.getMaxZoomLevel();
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) //on vérifie qu'on a bien les permissions
                    != PackageManager.PERMISSION_GRANTED) {
            }
            else{
                mMap.setMyLocationEnabled(true);
            }
            myHandler.postDelayed(this,1000);
        }
    };

    public void onResume(){
        super.onResume();
        myHandler = new Handler();
        myHandler.postDelayed(myRunnable,1000);
    }

    public void allera(View v){
        SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
        String a= pref.getString("derniereposition", "0e0");
        String[] liste=a.split("e");
        String pos=liste[0].concat(",").concat(liste[1]);
        Uri gmmIntentUri = Uri.parse("google.navigation:q=".concat(pos));//.concat("&mode=w"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);


    }

    public void onPause() {
        super.onPause();
        if(myHandler != null)
            myHandler.removeCallbacks(myRunnable);
    }

    public void onClick(View view) {
        // a remplacer par l'envoie d'un sms pos!!

        String number="0041786571605";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, "pos", null, null);
        LatLng lastloc = new LatLng(46.5, 5.5);
        //mMap.addMarker(new MarkerOptions().position(lastloc).title("vélo localisé"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lastloc));

        /*SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String a=pref.getString("derniereposition", "10.0e10.0");
        //Toast.makeText(this, a, Toast.LENGTH_LONG).show();
        String[] b=a.split("e");
        float lat=Float.parseFloat(b[0]);
        float lon=Float.parseFloat(b[1]);
        LatLng lastloc = new LatLng(lat, lon);
        if (view.getId() == R.id.Locate) {
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(lastloc).title("Velo"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(lastloc));
            mMap.getMinZoomLevel();
            mMap.setMyLocationEnabled(true);
            //codeicipourobtenirlalocalisation
            //SmsManager smsManager = SmsManager.getDefault();
            //for (int i=1;i<=10;i++){
            //smsManager.sendTextMessage("+33659615446", null, actuallocation, null, null);
            //}
        }*/
    }

    public void onMapReady(GoogleMap googleMap) {
        SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String a=pref.getString("derniereposition", "10e10");
        //Toast.makeText(this, a, Toast.LENGTH_LONG).show();
        String[] b=a.split("e");
        float lat=Float.parseFloat(b[0]);
        float lon=Float.parseFloat(b[1]);
        mMap = googleMap;
        LatLng lastloc = new LatLng(lat, lon);
        mMap.isMyLocationEnabled();
        //mMap.addMarker(new MarkerOptions().position(lastloc).title("vélo localisé"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(lastloc));
        //mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //mMap.resetMinMaxZoomPreference();
        mMap.setMyLocationEnabled(true);
}
}