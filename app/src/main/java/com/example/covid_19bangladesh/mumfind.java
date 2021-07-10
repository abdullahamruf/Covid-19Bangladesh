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


public class mumfind extends FragmentActivity implements
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
        setContentView(R.layout.activity_mumfind);


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
        mMap.animateCamera(CameraUpdateFactory.zoomBy(12));

        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }
        LatLng mum= new LatLng(  24.743448, 90.398384);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mum));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        LatLng mymensing = new LatLng(24.75205, 90.41684);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing)
                .title("SK Hospital,Mymensing"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(mymensing));

        LatLng mymensing1 = new LatLng(24.74428, 90.40949);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing1)
                .title("Mymensing Medical College Hospital,Mymensing"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(mymensing1));

        LatLng mymensing2 = new LatLng(24.75398, 90.40398);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing2)
                .title("Shodesh Hospital pvt,Mymensing"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(mymensing2));

        LatLng mymensing3 = new LatLng(24.74270, 90.40786);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing3)
                .title("Pranto pvt sepcialized hospital,Mymensing"));


        LatLng mymensing4 = new LatLng(24.74971, 90.40584);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing4)
                .title("Nexus Hospital ,Mymensing"));


        LatLng mymensing5 = new LatLng(24.73731, 90.40779);
        mMap.addMarker(new MarkerOptions()
                .position(mymensing5)
                .title("Liberty Hospital,Mymensing"));


        LatLng netrokona = new LatLng(24.81006, 90.86201);
        mMap.addMarker(new MarkerOptions()
                .position(netrokona)
                .title("Atpara Upozila Health Complex, Netrokona"));


        LatLng netrokona1 = new LatLng(24.87164, 90.73209);
        mMap.addMarker(new MarkerOptions()
                .position(netrokona1)
                .title("Netrokona General Hospital, Netrokona"));


        LatLng jamalpur = new LatLng(24.91641, 89.93160);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur)
                .title("Shekh Hasina Medical College,Jamalpur"));


        LatLng jamalpur1 = new LatLng(24.98224, 89.83630);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur1)
                .title("Melandaha Upozila Health Complex,Jamalpur"));


        LatLng jamalpur2 = new LatLng(24.89412, 89.71717);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur2)
                .title("Madarganj Upozila Health Complex,Jamalpur"));


        LatLng jamalpur3 = new LatLng(25.07788, 89.79939);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur3)
                .title("Islampur Upozila Health Complex,Jamalpur"));


        LatLng jamalpur4 = new LatLng(24.75533, 89.83585);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur4)
                .title("Sarishabari Upozila Health Complex,Jamalpur"));


        LatLng jamalpur5 = new LatLng(25.16188, 89.75890);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur5)
                .title("Dewanganj Upozila Health Complex,Jamalpur"));


        LatLng jamalpur6 = new LatLng(25.17752, 89.87051);
        mMap.addMarker(new MarkerOptions()
                .position(jamalpur6)
                .title("Bakshiganj Upozila Health Complex,Jamalpur"));


        LatLng sherpur = new LatLng(25.01829, 90.02463);
        mMap.addMarker(new MarkerOptions()
                .position(sherpur)
                .title("Sherpur Sadar Hospital,Sherpur"));



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