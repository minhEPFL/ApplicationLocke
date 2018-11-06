package com.example.minh.lock_e;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements View.OnClickListener , OnMapReadyCallback
{
    private GoogleMap mMap;
    private Location actuallocation;
    private LatLng Loc;
    private LocationManager locationManager;
    private LocationListener locationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteactivity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            public void onLocationChanged(Location location)
            {
                Loc=new LatLng(location.getLatitude(), location.getLongitude());
                actuallocation = location;



            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}};

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) //on vérifie qu'on a bien les permissions
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, Ask for permision
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        Button Localiser= (Button) findViewById(R.id.Locate);
        Localiser.setOnClickListener((View.OnClickListener)this);


    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.Locate) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, Ask for permision
                ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1);
            }
            else {
            }

            mMap.clear();

            if (Loc!=null){
            mMap.addMarker(new MarkerOptions().position(Loc).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Loc));
            mMap.getMinZoomLevel();
            mMap.setMyLocationEnabled(true);
            }
            //codeicipourobtenirlalocalisation
            //SmsManager smsManager = SmsManager.getDefault();
            //for (int i=1;i<=10;i++){
            //smsManager.sendTextMessage("+33659615446", null, actuallocation, null, null);
            //}
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng localisation = new LatLng(48.9, 2.33);
        mMap.isMyLocationEnabled();
        mMap.addMarker(new MarkerOptions().position(localisation).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localisation));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.resetMinMaxZoomPreference();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) //on vérifie qu'on a bien les permissions
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, Ask for permision
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS}, 1);
        }

        mMap.setMyLocationEnabled(true);
}}