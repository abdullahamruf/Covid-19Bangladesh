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


public class rajsahifind extends FragmentActivity implements
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
        setContentView(R.layout.activity_rajsahifind);


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
        LatLng mum= new LatLng(  24.374 ,88.60114);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mum));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        LatLng rajshahi = new LatLng(24.37214, 88.58142);
        mMap.addMarker(new MarkerOptions()
                .position(rajshahi)
                .title("CDM Hospital pvt,Rajshahi"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(rajshahi));

        LatLng rajshahi1 = new LatLng(24.37703, 88.57981);
        mMap.addMarker(new MarkerOptions()
                .position(rajshahi1)
                .title("Infectious Disease Hospital,Rajshahi"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(rajshahi1));

        LatLng rajshahi2 = new LatLng(24.38053, 88.58657);
        mMap.addMarker(new MarkerOptions()
                .position(rajshahi2)
                .title("Mohila Krira Complex,Rajshahi"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(rajshahi2));

        LatLng rajshahi3 = new LatLng(24.36615, 88.66347);
        mMap.addMarker(new MarkerOptions()
                .position(rajshahi3)
                .title("Rajshahi Cancer hospital and research centre trust,Rajshahi"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(rajshahi3));

        LatLng rajshahi4 = new LatLng(24.37757, 88.57982);
        mMap.addMarker(new MarkerOptions()
                .position(rajshahi4)
                .title("Leprosy control centre,Rajshahi"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(rajshahi4));

        LatLng pabna = new LatLng(23.99967, 89.26399);
        mMap.addMarker(new MarkerOptions()
                .position(pabna)
                .title("Amina Monsur Girls High School,Pabna"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(pabna));

        LatLng joypurhat = new LatLng(24.96513, 89.08286);
        mMap.addMarker(new MarkerOptions()
                .position(joypurhat)
                .title("Institute of Health Technology,Joypurhat"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(joypurhat));

        LatLng naogaon = new LatLng(24.80905, 88.94552);
        mMap.addMarker(new MarkerOptions()
                .position(naogaon)
                .title("Old Hospital,Naogaon"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(naogaon));

        LatLng chapainobabganj = new LatLng(24.60380, 88.25319);
        mMap.addMarker(new MarkerOptions()
                .position(chapainobabganj)
                .title("Chapainobabgonj polytechnic institute,Chapainobabganj"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(chapainobabganj));

        LatLng Bogura = new LatLng(24.83561, 89.37417);
        mMap.addMarker(new MarkerOptions()
                .position(Bogura)
                .title("Mohammad Ali Hospital, Bogura"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(Bogura));

        LatLng sirajganj = new LatLng(24.48933, 89.68293);
        mMap.addMarker(new MarkerOptions()
                .position(sirajganj)
                .title("Khokshabari Hospital, Sirajganj"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sirajganj));

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