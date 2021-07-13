package com.example.covid_19bangladesh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

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
public class barisalfind extends FragmentActivity implements
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
        setContentView(R.layout.activity_barisalfind);


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
        LatLng Barishal = new LatLng(22.68637, 90.36147);
        mMap.addMarker(new MarkerOptions()
                .position(Barishal)
                .title("Sher-E-Bangla Medical College Hospital,Barishal"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(Barishal));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        LatLng Bhola = new LatLng(22.67582, 90.65574);
        mMap.addMarker(new MarkerOptions()
                .position( Bhola)
                .title("Bhola General Hospital"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng( Bhola));

        LatLng Jhalokathi = new LatLng(23.44154, 91.17389);
        mMap.addMarker(new MarkerOptions()
                .position(Jhalokathi)
                .title("Jhalokathi Sadar Hospital,Jhalokathi"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Jhalokathi));

        LatLng Barguna = new LatLng(22.15631, 90.12817);
        mMap.addMarker(new MarkerOptions()
                .position(Barguna)
                .title("Zilla Sadar Government Hospital,Barguna"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Barguna));

        LatLng  Patuakhali = new LatLng(22.35829, 90.34156);
        mMap.addMarker(new MarkerOptions()
                .position( Patuakhali)
                .title("District Family Planning Office, Patuakhali"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng( Patuakhali));

        LatLng Pirojpur = new LatLng(22.57874, 89.97603);
        mMap.addMarker(new MarkerOptions()
                .position( Pirojpur)
                .title("Sadar Hospital, Pirojpur"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng( Pirojpur));

        LatLng Pirojpur2 = new LatLng(22.62038, 90.06241);
        mMap.addMarker(new MarkerOptions()
                .position(Pirojpur2)
                .title("Kaukhali Upazila Health Complex,Pirojpur"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(Pirojpur2));


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

    }}