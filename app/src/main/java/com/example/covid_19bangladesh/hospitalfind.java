package com.example.covid_19bangladesh;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class hospitalfind extends FragmentActivity implements
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
        setContentView(R.layout.activity_hospitalfind);


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
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        currentUserLocationMarker = mMap.addMarker(markerOptions);

        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }

    }
    public void onclick(View v) {


        switch (v.getId()) {

        /*    case R.id.ic_magnify:
                // at last we calling our map fragment to update.
              EditText addressField = (EditText) findViewById(R.id.input_search);
                String address = addressField.getText().toString();
                List<Address> addressList = null;
                MarkerOptions userMarkerOptions = new MarkerOptions();
                if (!TextUtils.isEmpty(address))
                {
                    Geocoder geocoder = new Geocoder(this);
                    try
                    {
                        addressList = geocoder.getFromLocationName(address, 6);
                        if (addressList != null)
                        {
                            for (int i=0; i<addressList.size(); i++)
                            {
                                Address userAddress = addressList.get(i);
                                LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());
                                userMarkerOptions.position(latLng);
                                userMarkerOptions.title(address);
                                userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
                                mMap.addMarker(userMarkerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                            }
                        }
                        else
                        {
                            Toast.makeText(this, "Location not found...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(this, "please write any location name...", Toast.LENGTH_SHORT).show();
                }
                break;
*/
            case R.id.hospital:
                hospital();

                Toast.makeText(this, "Showing  Hospitals For Covid-19 in Dhaka City...", Toast.LENGTH_SHORT).show();
                break;

        }
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


    public void hospital() {



        LatLng sydney = new LatLng(23.821226, 90.410681);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Kurmitola General hospital"));
     //   mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        LatLng  rasel = new   LatLng   (23.776366, 90.411461);
        mMap.addMarker(new MarkerOptions()
                .position(rasel)
                .title("sheikh Rasel Gastroliver Institute and  Hospital"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(rasel));
        LatLng lalkuthi = new LatLng(23.788373, 90.346210);
        mMap.addMarker(new MarkerOptions()
                .position(lalkuthi)
                .title("Mirpur Lalkuthi Hospital"));
     //   mMap.moveCamera(CameraUpdateFactory.newLatLng(lalkuthi));
        LatLng general = new LatLng(23.714228, 90.405031);
        mMap.addMarker(new MarkerOptions()
                .position(general)
                .title("Mohanagar General Hospital, Babubazar,Dhaka"));
    //    mMap.moveCamera(CameraUpdateFactory.newLatLng(general));
        LatLng railway = new LatLng(23.736269, 90.425090);
        mMap.addMarker(new MarkerOptions()
                .position(railway)
                .title("Railway Hospital,Kamolapur"));
     //   mMap.moveCamera(CameraUpdateFactory.newLatLng(railway));
        LatLng kwait = new LatLng(23.870575, 90.403590);
        mMap.addMarker(new MarkerOptions()
                .position(kwait)
                .title("Bangladesh Kuwait Moitree Hospital, Uttara, Dhaka"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(kwait));

        LatLng kacpur = new LatLng(23.70305, 90.38872);
        mMap.addMarker(new MarkerOptions()
                .position(kacpur)
                .title("Sajida foundation hospital,Kacpur"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(kacpur));

        LatLng tbhs = new LatLng(23.774412478833334, 90.36833774104628);
        mMap.addMarker(new MarkerOptions()
                .position(tbhs)
                .title("250 Beded TB Hospital Shyamoli,Dhaka"));
        LatLng addin = new LatLng(23.748483728742002, 90.40549131036293);
        mMap.addMarker(new MarkerOptions()
                .position(addin)
                .title("Ad-Din Medical College Hospital Mogbazar, Dhaka"));
        LatLng amz = new LatLng(23.784424666733145, 90.42603975454038);
        mMap.addMarker(new MarkerOptions()
                .position(amz)
                .title("AMZ Hospital Ltd.Dhaka"));
        LatLng anuwar = new LatLng(23.74550211664356, 90.38248938152749);
        mMap.addMarker(new MarkerOptions()
                .position(anuwar)
                .title("Anwar Khan Modern Medical College Hospital,Dhaka"));
        LatLng asgar = new LatLng(23.708081646076973, 90.4236768968682);
        mMap.addMarker(new MarkerOptions()
                .position(asgar)
                .title("Asgar Ali Hospital,Dhaka"));
        LatLng bbsm = new LatLng(23.740047867268416, 90.39466596803341);
        mMap.addMarker(new MarkerOptions()
                .position(bbsm)
                .title("Bangabandhu Sheikh Mujib Medical University (BSMMU)"));
        LatLng hsg = new LatLng(23.886779402142107, 90.39996666803624);
        mMap.addMarker(new MarkerOptions()
                .position(hsg)
                .title("Bangladesh Institute of Health Sciences General Hospital, Dhaka"));
        LatLng mdc = new LatLng(23.750653509456882, 90.36979913919829);
        mMap.addMarker(new MarkerOptions()
                .position(mdc)
                .title("Bangladesh Medical College & Hospital,Dhaka"));
        LatLng bsh = new LatLng(23.77633014081177, 90.36260722570485);
        mMap.addMarker(new MarkerOptions()
                .position(bsh)
                .title("Bangladesh Specialized Hospital Limited,Dhaka"));
        LatLng rampura = new LatLng(23.75932003383066, 90.4183178257045);
        mMap.addMarker(new MarkerOptions()
                .position(rampura)
                .title("Better life Hospital, Rampura,Dhaka"));
        LatLng birdem = new LatLng(23.73904020580936, 90.39647136803346);
        mMap.addMarker(new MarkerOptions()
                .position(birdem)
                .title("BIRDEM General Hospital,Dhaka"));
        LatLng care = new LatLng(23.76913441679264, 90.36857173919866);
        mMap.addMarker(new MarkerOptions()
                .position(care)
                .title("Care Medical College Hospital,Dhaka"));
        LatLng rajarbag = new LatLng(23.736518058436303, 90.4167390257041);
        mMap.addMarker(new MarkerOptions()
                .position(rajarbag)
                .title("Central Police Hospital, Rajarbag,Dhaka"));
        LatLng city = new LatLng(23.754243062565834, 90.36547876803371);
        mMap.addMarker(new MarkerOptions()
                .position(city)
                .title("City Hospital & Diagnostic Center,Dhaka"));
        LatLng dc = new LatLng(23.7740326451489, 90.3614897968695);
        mMap.addMarker(new MarkerOptions()
                .position(dc)
                .title("Dhaka Central International Medical College & Hospital,Dhaka"));
        LatLng dmc = new LatLng(23.72582225955019, 90.39707746803316);
        mMap.addMarker(new MarkerOptions()
                .position(dmc)
                .title("Dhaka Medical College Hospita,Dhaka"));

        LatLng dhan = new LatLng(23.7457781354227, 90.3849000502697);
        mMap.addMarker(new MarkerOptions()
                .position(dhan)
                .title("Dhanmondi Clinic Pvt Ltd,Dhaka"));

        LatLng dk = new LatLng(23.74528363758772, 90.38341875453963);
        mMap.addMarker(new MarkerOptions()
                .position(dk)
                .title("Dhanmondi General And Kidney Hospital Limited,Dhaka"));

        LatLng dncc = new LatLng(23.774472889125278, 90.40086919686948);
        mMap.addMarker(new MarkerOptions()
                .position(dncc)
                .title("DNCC Dedicated Covid-19 Hospital,Dhaka"));

        LatLng azmal = new LatLng(23.809219778680713, 90.36748876803476);
        mMap.addMarker(new MarkerOptions()
                .position(azmal)
                .title("Dr. Azmal Hospital Ltd,Dhaka"));

        LatLng enam = new LatLng(23.838541023222476, 90.2529413968707);
        mMap.addMarker(new MarkerOptions()
                .position(enam)
                .title("Enam Medical College & Hospital,Dhaka"));

        LatLng evercaree = new LatLng(23.81013234554744, 90.43105759687013);
        mMap.addMarker(new MarkerOptions()
                .position(evercaree)
                .title("Evercare Hospital Limited Dhaka,Dhaka"));

        LatLng famous = new LatLng(23.762271728707134, 90.44350848337534);
        mMap.addMarker(new MarkerOptions()
                .position(famous)
                .title("Famous Specialized Hospital,Dhaka"));

        LatLng gono = new LatLng(23.743694781662406, 90.38267146803351);
        mMap.addMarker(new MarkerOptions()
                .position(gono)
                .title("Gonoshasthaya Nagar Hospital,Dhaka"));

        LatLng green = new LatLng(23.746701814743233, 90.38581199686895);
        mMap.addMarker(new MarkerOptions()
                .position(green)
                .title("Green Life Medical College Hospital,Dhaka"));
        LatLng cg = new LatLng(23.86905152047006, 90.39394812570664);
        mMap.addMarker(new MarkerOptions()
                .position(cg)
                .title("Hi-Care General Hospital Ltd, Dhaka"));
        LatLng holy = new LatLng(23.746243777033314, 90.40119584586343);
        mMap.addMarker(new MarkerOptions()
                .position(holy)
                .title("Holy Family Red Cresent Medical College Hospita,Dhaka"));
        LatLng ibnesin = new LatLng(23.778902599828267, 90.36251513919885);
        mMap.addMarker(new MarkerOptions()
                .position(ibnesin)
                .title("IBN SINA Medical College Hospital,Dhaka"));
        LatLng imp = new LatLng(23.768052162029804, 90.39907812570469);
        mMap.addMarker(new MarkerOptions()
                .position(imp)
                .title("Impulse Hospital,Dhaka"));
        LatLng in = new LatLng(23.77726862554089, 90.40587010851596);
        mMap.addMarker(new MarkerOptions()
                .position(in)
                .title("Infectious Diseases Hospital,Dhaka"));
        LatLng insaf = new LatLng(23.750410207821812, 90.40240315269223);
        mMap.addMarker(new MarkerOptions()
                .position(insaf)
                .title("Insaf Barakah Kidney and General Hospital,Dhaka"));
        LatLng japan = new LatLng(23.74314451565762, 90.37462981361507);
        mMap.addMarker(new MarkerOptions()
                .position(japan)
                .title("Japan Bangladesh Friendship Hospital, Dhaka"));
        LatLng jp = new LatLng(23.894521489221564, 90.37655115454247);
        mMap.addMarker(new MarkerOptions()
                .position(jp)
                .title("Japan East West Medical College Hospital,Dhaka"));
        LatLng lab = new LatLng(23.742131121982673, 90.38303219686887);
        mMap.addMarker(new MarkerOptions()
                .position(lab)
                .title("Labaid Hospital,Dhaka"));
        LatLng ml= new LatLng(23.756796518479906, 90.36631185453986);
        mMap.addMarker(new MarkerOptions()
                .position(ml)
                .title("Millennium Heart & General Hospital Limited,Dhaka"));
        LatLng mw = new LatLng(23.743466761338333, 90.40774831221032);
        mMap.addMarker(new MarkerOptions()
                .position(mw)
                .title("Monowara Hospital Ltd.,Dhaka"));
        LatLng mug = new LatLng(23.73222835924508, 90.43001709686868);
        mMap.addMarker(new MarkerOptions()
                .position(mug)
                .title("Mugda Medical College and Hospital,Dhaka"));
        LatLng nh = new LatLng(23.804562929740793, 90.36192762042255);
        mMap.addMarker(new MarkerOptions()
                .position(nh)
                .title("National Heart Foundation Hospital & Research Institute,Dhaka"));
        LatLng ni = new LatLng(23.77059609556517, 90.36968489686936);
        mMap.addMarker(new MarkerOptions()
                .position(ni)
                .title("National Institute of Cardiovascular Diseases,Dhaka"));
        LatLng chest = new LatLng(23.77603456825285, 90.40946191036343);
        mMap.addMarker(new MarkerOptions()
                .position(chest)
                .title("National Institute of Diseases of the Chest and Hospital,Dhaka"));
        LatLng mental = new LatLng(23.77258127372881, 90.36818536803405);
        mMap.addMarker(new MarkerOptions()
                .position(mental)
                .title("National Institute of Mental Health and Research,Dhaka"));
        LatLng nins = new LatLng(23.776301394805127, 90.37077886803415);
        mMap.addMarker(new MarkerOptions()
                .position(nins)
                .title("National Institute of Neuro Science (NINS),Dhaka"));


        LatLng no = new LatLng(23.774593213199353, 90.3696891563877);
        mMap.addMarker(new MarkerOptions()
                .position(no)
                .title("National Institute of Ophthalmology, Dhaka(NIO)"));


        LatLng popular = new LatLng(23.740674891224607, 90.37988056022189);
        mMap.addMarker(new MarkerOptions()
                .position(popular)
                .title("Popular Medical College & Hospital,Dhaka"));
        LatLng proshanti = new LatLng(23.743936619123136, 90.41557203919817);
        mMap.addMarker(new MarkerOptions()
                .position(proshanti)
                .title("Proshanti Hospital,Dhaka"));










    }

}