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


public class khulnafind extends FragmentActivity implements
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
        setContentView(R.layout.activity_khulnafind);


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


        LatLng khulna = new LatLng(22.83143, 89.54352);
        mMap.addMarker(new MarkerOptions()
                .position(khulna)
                .title("Khulna Diabetic Hospital,Khulna"));


        LatLng bagerhat = new LatLng(22.66801, 89.78854);
        mMap.addMarker(new MarkerOptions()
                .position(bagerhat)
                .title("250 bededsadar hospital's extension building,bagerhat"));



        LatLng jhinaidah = new LatLng(23.54208, 89.19120);
        mMap.addMarker(new MarkerOptions()
                .position(jhinaidah)
                .title("Shishu hHospital,Jhinaidah"));


        LatLng chuadanga = new LatLng(23.63523, 88.84826);
        mMap.addMarker(new MarkerOptions()
                .position(chuadanga)
                .title("Sadar Hospital, Chuadanga"));


        LatLng shatkhira = new LatLng(22.69024, 89.04693);
        mMap.addMarker(new MarkerOptions()
                .position(shatkhira)
                .title("Medical college Hospital Doctors Dormetory,Shatkhira"));


        LatLng kushtia1 = new LatLng(23.90177, 89.11818);
        mMap.addMarker(new MarkerOptions()
                .position(kushtia1)
                .title("Kushtia Diabetic Hospital, kushtia"));



        LatLng kushtia2 = new LatLng(23.90177, 89.11818);
        mMap.addMarker(new MarkerOptions()
                .position(kushtia2)
                .title("Kushtia General Hospital, kushtia"));


        LatLng meherpur = new LatLng(23.90177, 89.11818);
        mMap.addMarker(new MarkerOptions()
                .position(meherpur)
                .title("impact hospital private, meherpur"));


        LatLng jashore = new LatLng(23.14760, 89.23417);
        mMap.addMarker(new MarkerOptions()
                .position(jashore)
                .title("TB Hospital, Jashore"));


        LatLng narail1 = new LatLng(23.17227, 89.49931);
        mMap.addMarker(new MarkerOptions()
                .position(narail1)
                .title("Sadar Hospital, Narail"));


        LatLng narail2 = new LatLng(23.04104, 89.63624);
        mMap.addMarker(new MarkerOptions()
                .position(narail2)
                .title("Kalia upozila Health Complex, Narail"));


        LatLng narail3 = new LatLng(23.18434, 89.64770);
        mMap.addMarker(new MarkerOptions()
                .position(narail3)
                .title("Lohagara upozila Health Complex, Narail"));


        LatLng magura = new LatLng(23.48643, 89.42151);
        mMap.addMarker(new MarkerOptions()
                .position(magura)
                .title("Magura Sadar Hospital, Magura"));

    }

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