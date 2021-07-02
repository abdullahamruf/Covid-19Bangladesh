package com.example.covid_19bangladesh;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
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
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class tracebd extends FragmentActivity implements
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
        setContentView(R.layout.activity_tracebd);


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
         LatLng bd = new LatLng(23.6943117,  90.344352);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bd));


      // LatLng dhaka = new LatLng(23.810331, 90.412521);
     // mMap.addMarker(new MarkerOptions().position(dhaka).title("Dhaka"));
       Circle circle = mMap.addCircle(new CircleOptions()
              .center(new LatLng(23.810331, 90.412521))
             .radius(5000)
             .strokeColor(Color.RED)
               .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng(23.810331, 90.412521));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(dhaka));

      // LatLng gazipur = new LatLng(23.999941, 90.420273);
       // mMap.addMarker(new MarkerOptions().position(gazipur).title("Gazipur"));
        Circle circle1 = mMap.addCircle(new CircleOptions()
                .center(new LatLng(23.999941, 90.420273))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(100,70,70)));
        drawCircle(new LatLng(23.777176, 90.399452));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(gazipur));

        //LatLng ctg = new LatLng( 22.341900, 91.815536);
        // mMap.addMarker(new MarkerOptions().position(gazipur).title("Gazipur"));
        Circle circle2 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.341900, 91.815536))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 22.341900, 91.815536));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(gazipur));
       // LatLng bogora = new LatLng( 24.85098,  89.37108);

        // mMap.addMarker(new MarkerOptions().position(gazipur).title("Gazipur"));

        Circle circle3 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.85098,  89.37108))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 24.85098,  89.37108));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(gazipur))

        Circle circle4 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.89643,  91.86738))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 24.89643,  91.86738));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle5 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.46203,  91.17936))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 23.46203,  91.17936));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle6 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.62408,  90.50036))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 23.62408,  90.50036));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle7 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.60290,  89.83381))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 23.60290,  89.83381));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle8 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.84687,  89.53868))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 22.84687,  89.53868));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle9 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 21.42979,  92.00359))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 21.42979,  92.00359));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle circle10 = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.82498,  91.10176))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(135,0,0)));
        drawCircle(new LatLng( 22.82498,  91.10176));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle barisal = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.70124,  90.35260))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 22.70124,  90.35260));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle jessore = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.17853,  89.17896))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 23.17853,  89.17896));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle dinajpur = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.636574,  89.17896))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 25.636574,  88.636322));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle mymon = mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.76608,  90.41625))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 24.76608,  90.41625));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle munshi= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.54417,  90.52652))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 23.54417,  90.52652));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Rangpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.75209, 89.25530))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 23.54417,  90.52652));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle khustia= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.91443, 89.12019))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 23.91443,  89.12019));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle tangail= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.26505, 89.92260))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 24.26505,  89.92260));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Rajbari= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.76516, 89.64875))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 23.76516,  89.64875));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));
        Circle Kishoreganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.44091, 90.78416))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(50,50,0)));
        drawCircle(new LatLng( 24.44091,  90.78416));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Gopalganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.01437, 89.82386))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 23.01437,  89.82386));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Brahamanbaria= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.96868974609237, 91.11143027203956))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 23.96868974609237, 91.11143027203956));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Narsingdi= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.913673596214704, 90.71269498151455))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 23.913673596214704, 90.71269498151455));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Chandpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.228073939287725, 90.66030378877478))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 23.228073939287725, 90.66030378877478));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Sunamganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.066797577381532, 91.40738521677565))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 25.066797577381532, 91.40738521677565));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Sirajganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.454948014908357, 89.67460905794067))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 24.454948014908357, 89.67460905794067));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Lakshmipur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.946748949471473, 90.83264273455654))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 22.946748949471473, 90.83264273455654));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Jhenaidah= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.562725192643867, 89.17250400205145))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng(23.562725192643867, 89.17250400205145));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Feni= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.016916879430237, 91.39719952363248))
                .radius(5000)
                .strokeColor(Color.RED)
                .fillColor(Color.rgb(25,5,50)));
        drawCircle(new LatLng( 23.016916879430237, 91.39719952363248));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle habiganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.392628005273263, 91.42221176045027))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.392628005273263, 91.42221176045027));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Maulvibazar= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.484725042771906, 91.76798326519669))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.484725042771906, 91.76798326519669));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Shariatpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.220319850138665, 90.34331593682491))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.220319850138665, 90.34331593682491));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Jamalpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.94276792220404, 89.9434107062917))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.94276792220404, 89.9434107062917));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Manikganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.870146448033868, 90.0186733518559))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.870146448033868, 90.0186733518559));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Patuakhali= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.366641540829388, 90.32637350405648))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.366641540829388, 90.32637350405648));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Chuadanga= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.641830632443988, 88.85767855443233))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.641830632443988, 88.85767855443233));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Madaripur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.165174595702393, 90.1934186402233))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.165174595702393, 90.1934186402233));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Pabna= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.020029905914434, 89.25193608912268))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.020029905914434, 89.25193608912268));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Narail= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.167008816654597, 89.5010538822677))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.167008816654597, 89.5010538822677));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Naogaon= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.79977858109769, 88.92644980055883))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.79977858109769, 88.92644980055883));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Thakurgaon= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 26.03748282386473, 88.46440498398108))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 26.03748282386473, 88.46440498398108));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Gaibandha= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.335189944562618, 89.5353324413745))
                .radius(5000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 25.335189944562618, 89.5353324413745));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Nilphamari= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.947471456765555, 88.8332930018319))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 25.947471456765555, 88.8332930018319));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Joypurhat= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.10093131746992, 89.02053689894214))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 25.10093131746992, 89.02053689894214));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Natore= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.421352778920994, 88.96953173429068))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 24.421352778920994, 88.96953173429068));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Satkhira= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.74208366316425, 89.05673915195989))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.74208366316425, 89.05673915195989));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Pirojpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.584872538740683, 89.9725233276208))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.584872538740683, 89.9725233276208));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Rangamati= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.66425733071436, 92.17812993623774))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.66425733071436, 92.17812993623774));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Bagerhat= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.672682941185666, 89.74777652745745))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.672682941185666, 89.74777652745745));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Magura= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.490183627951502, 89.41387688006536))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 23.490183627951502, 89.41387688006536));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));


        Circle Barguna= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.166335891605957, 90.11972669298241))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(50,0,0)));
        drawCircle(new LatLng( 22.166335891605957, 90.11972669298241));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Kurigram= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.823388725905588, 89.636995429732581))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 25.823388725905588, 89.63699542973258));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Lalmonirhat= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.92265000005512, 89.44554184699761))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 25.92265000005512, 89.44554184699761));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Bhola= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.68774176849388, 90.64314632736387))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 22.68774176849388, 90.64314632736387));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Bandarban= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.203439874226678, 92.21399517960971))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 22.203439874226678, 92.21399517960971));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Netrakona= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.881991358392852, 90.72736836276638))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 24.881991358392852, 90.72736836276638));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Chapainawabganj= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 24.581351272855052, 88.27081183240085))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 24.581351272855052, 88.27081183240085));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Jhalokati= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 22.64616889250974, 90.1960524664871))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 22.64616889250974, 90.1960524664871));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Khagrachhari= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.11161059136975, 91.99090520106033))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 23.11161059136975, 91.99090520106033));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Panchagarh= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 26.340982322549877, 88.55658921608342))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 26.340982322549877, 88.55658921608342));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Meherpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 23.775228954919328, 88.63131570861803))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 23.775228954919328, 88.63131570861803));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));

        Circle Sherpur= mMap.addCircle(new CircleOptions()
                .center(new LatLng( 25.02052284330845, 90.01210136550023))
                .radius(5000)
                .strokeColor(Color.YELLOW)
                .fillColor(Color.rgb(0,50,0)));
        drawCircle(new LatLng( 25.02052284330845, 90.01210136550023));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(8));









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

      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
     //   mMap.animateCamera(CameraUpdateFactory.zoomBy(15));

        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
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
    private void drawCircle(LatLng point){

        // Instantiating CircleOptions to draw a circle around the marker
        CircleOptions circleOptions = new CircleOptions();
        // Specifying the center of the circle
        circleOptions.center(point);
        // Radius of the circle
        circleOptions.radius(100);
        // Border color of the circle
        circleOptions.strokeColor(Color.BLACK);
        // Fill color of the circle
        circleOptions.fillColor(0x30ff0000);
        // Border width of the circle
        circleOptions.strokeWidth(2);
        // Adding the circle to the GoogleMap
        mMap.addCircle(circleOptions);

    }

}





