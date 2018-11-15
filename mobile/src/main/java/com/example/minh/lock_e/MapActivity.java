package com.example.minh.lock_e;

import android.os.Bundle;
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

public class MapActivity extends MenuActivity implements View.OnClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteactivity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button Localiser= (Button) findViewById(R.id.Locate);
        Localiser.setOnClickListener((View.OnClickListener)this);

        //locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        //locationListener = new LocationListener() {
            /*public void onLocationChanged(Location location)
            {
                if (Loc==null){Toast.makeText(getBaseContext(), "vélo localisé", Toast.LENGTH_LONG).show();}

                Loc=new LatLng(location.getLatitude(), location.getLongitude());
                Loc.toString();
                //actuallocation = location;
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}};*/

       /* if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) //on vérifie qu'on a bien les permissions
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, Ask for permision
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }*/

        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //locationManager.removeUpdates(locationListener);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //locationManager.removeUpdates(locationListener);
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    public void onClick(View view) {
        SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        String a=pref.getString("derniereposition", "0e0");

        Toast.makeText(this, a, Toast.LENGTH_LONG).show();

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
        }
    }

    public void onMapReady(GoogleMap googleMap) {
        SharedPreferences pref = getSharedPreferences("preferences", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        String a=pref.getString("derniereposition", "0e0");
        Toast.makeText(this, a, Toast.LENGTH_LONG).show();

        String[] b=a.split("e");
        float lat=Float.parseFloat(b[0]);
        float lon=Float.parseFloat(b[1]);

        mMap = googleMap;

        LatLng lastloc = new LatLng(lat, lon);

        mMap.isMyLocationEnabled();
        mMap.addMarker(new MarkerOptions().position(lastloc).title("vélo localisé"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lastloc));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.resetMinMaxZoomPreference();
        mMap.setMyLocationEnabled(true);
}}