package com.example.covid_19bangladesh;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class chittagangfind extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;
    int i;
    private double latitide;
    private double longitude;


    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagangfind);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkUserLocationPermission();
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            buildGoogleApiClient();

            mMap.setMyLocationEnabled(true);
        }


    }


    public boolean checkUserLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code);
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Request_User_Location_Code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (googleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "Permission Denied...", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }


    protected synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location) {
        latitide = location.getLatitude();
        longitude = location.getLongitude();

        lastLocation = location;

        if (currentUserLocationMarker != null) {
            currentUserLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Your Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        currentUserLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
       mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }
        LatLng Chittagong = new LatLng(22.34086, 91.83774);
        mMap.addMarker(new MarkerOptions()
                .position(Chittagong)
                .title("Chittagong General Hospital,Chittagong"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Chittagong));
       // mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        LatLng Khagrachori = new LatLng(23.11160, 91.99217);
        mMap.addMarker(new MarkerOptions()
                .position(Khagrachori)
                .title("Khagrachari Medical Centre,Khagrachari"));


        LatLng Comilla = new LatLng(23.44154, 91.17389);
        mMap.addMarker(new MarkerOptions()
                .position(Comilla)
                .title("Modern Hospital,Comilla"));


        LatLng Rangamati = new LatLng(22.66433, 92.16095);
        mMap.addMarker(new MarkerOptions()
                .position(Rangamati)
                .title("Rangamati Govt. College,Rangamati"));


        LatLng Chittagong2 = new LatLng(22.39275, 91.75851);
        mMap.addMarker(new MarkerOptions()
                .position(Chittagong2)
                .title("Bangladesh Institute of Tropical and Infectious Disease, Chittagong"));


        LatLng Feni = new LatLng(23.01029, 91.37783);
        mMap.addMarker(new MarkerOptions()
                .position(Feni)
                .title("Trauma Centre, Feni"));


        LatLng Chandpur = new LatLng(23.22500, 90.66009);
        mMap.addMarker(new MarkerOptions()
                .position(Chandpur)
                .title("Private hospital,Chandpur"));


        LatLng Brahmanbari = new LatLng(23.97635, 91.11156);
        mMap.addMarker(new MarkerOptions()
                .position(Brahmanbari)
                .title("250 Bedded General Hospital, Brahmanbari"));


        LatLng CBazar = new LatLng(21.44507, 92.10009);
        mMap.addMarker(new MarkerOptions()
                .position(CBazar)
                .title("Ramu Upazila Health Complex,Cox's Bazar"));


        LatLng Bandarban = new LatLng(22.18985, 92.22645);
        mMap.addMarker(new MarkerOptions()
                .position(Bandarban)
                .title("Bandarban Sadar Hospital,Bandarban"));


        LatLng Noakhali = new LatLng(22.87278, 91.08848);
        mMap.addMarker(new MarkerOptions()
                .position(Noakhali)
                .title("Noakhali General Hospital,Noakhali"));



    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }



}