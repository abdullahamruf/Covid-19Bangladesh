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


public class rangpurfind extends FragmentActivity implements
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
        setContentView(R.layout.activity_rangpurfind);


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
        LatLng rangpur= new LatLng( 25.744860,  		89.2755893);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rangpur));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        LatLng rangpur1 = new LatLng(25.73245, 89.23810);
        mMap.addMarker(new MarkerOptions()
                .position(rangpur1)
                .title("100 bed Shishu Hospital, Rangpur"));


        LatLng rangpur2 = new LatLng(25.72917, 89.27612);
        mMap.addMarker(new MarkerOptions()
                .position(rangpur2)
                .title("Chest Hospital ,Tajhat, Rangpur"));


        LatLng rangpur3 = new LatLng(25.72917, 89.27612);
        mMap.addMarker(new MarkerOptions()
                .position(rangpur3)
                .title("Haragach 31 Beded Hospital, Rangpur"));


        LatLng kurigram = new LatLng(25.80863, 89.64470);
        mMap.addMarker(new MarkerOptions()
                .position(kurigram)
                .title("Adhunik Sadar Hospital, kurigram"));


        LatLng dinajpur = new LatLng(25.79344, 88.60694);
        mMap.addMarker(new MarkerOptions()
                .position(dinajpur)
                .title("Kaharol Upozila Health Complex, Dinajpur"));


        LatLng dinajpur1 = new LatLng(25.66204, 88.88397);
        mMap.addMarker(new MarkerOptions()
                .position(dinajpur1)
                .title("LAMB Hospital Parbotipur, Dinajpur"));


        LatLng lal = new LatLng(25.92277, 89.45551);
        mMap.addMarker(new MarkerOptions()
                .position(lal)
                .title("Lalmonirhat Nursing College,Lalmonirhat"));


        LatLng lal1 = new LatLng(25.91355, 89.44397);
        mMap.addMarker(new MarkerOptions()
                .position(lal1)
                .title("Railway Hospital,Lalmonirhat"));



        LatLng lal2 = new LatLng(25.91278, 89.43871);
        mMap.addMarker(new MarkerOptions()
                .position(lal2)
                .title("Hostel of Govt Girls College,Lalmonirhat"));


        LatLng pancha = new LatLng(26.34454, 88.55701);
        mMap.addMarker(new MarkerOptions()
                .position(pancha)
                .title("Diabetics hospital,panchagor"));


        LatLng thakurgaon = new LatLng(26.02868, 88.47504);
        mMap.addMarker(new MarkerOptions()
                .position(thakurgaon)
                .title("Thakurgaon technical School and college,Thakurgaon"));


        LatLng nilphamari = new LatLng(25.93049, 88.84552);
        mMap.addMarker(new MarkerOptions()
                .position(nilphamari)
                .title("Adhunik sadar hospital, Nilphamari"));


        LatLng gaibandha = new LatLng(25.32330, 89.50999);
        mMap.addMarker(new MarkerOptions()
                .position(gaibandha)
                .title("Ansar VDP training centre,Gaibandha"));


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