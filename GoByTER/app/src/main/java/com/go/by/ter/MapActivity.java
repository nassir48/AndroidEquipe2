package com.go.by.ter;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback{

    private GoogleMap mMap;
    private static final int MY_LOCATION_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_map );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                .findFragmentById ( R.id.map );
        mapFragment.getMapAsync ( this );
     //   mMap.setMyLocationEnabled ( true );
       // LatLng l = new LatLng (10.7,12.9);
      //  Marker m =mMap.addMarker ( new MarkerOptions ().position(l).title ( "Arret Dakar" ));
        // getLastKnownLocation()



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override


    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng dakar = new LatLng ( 14.6757, -17.4334 );
        mMap.addMarker ( new MarkerOptions ().position ( dakar ).title ( "Arrêt Dakar" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7504, -17.3909 ) ).title ( "Arrêt Pikine" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7181, -17.4340 ) ).title ( "Arrêt Hanne" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng (14.6973, -17.4427 ) ).title ( "Arrêt Colobane" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7391, -17.4042 ) ).title ( "Arrêt Beaux Maraîchers" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7618, -17.3741 ) ).title ( "Arrêt Thiaroye" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7163, -17.1988 ) ).title ( "Arrêt Diamnadio" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.6985, -17.2282 ) ).title ( "Arrêt Bargny" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7157, -17.2710 ) ).title ( "Arrêt Rufisque" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7445, -17.3156 ) ).title ( "Arrêt Keur Mbaye Fall" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7840, -17.3098 ) ).title ( "Arrêt Keur Massar" ) );
        mMap.addMarker ( new MarkerOptions ().position ( new LatLng ( 14.7716, -17.3576 ) ).title ( "Arrêt Yeumbeul" ) );

        mMap.moveCamera ( CameraUpdateFactory.newLatLng ( dakar ) );

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) return;
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }
}
