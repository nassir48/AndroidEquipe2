package com.go.by.ter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class LocalisationActivity<suppressWarning> extends AppCompatActivity implements LocationListener {
    private LocationManager Lm;
    private static final int PERMS_CALL_ID=1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    // @SuppressWarnings("MissingPermission")
    protected void onResume() {
        super.onResume();
        checkPermssions();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermssions(){
        Lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            },PERMS_CALL_ID);
            return;
        }
        if (Lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
        }
        if(Lm.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)){
            Lm.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER,10000,0,this);
        }
        if(Lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
            Lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,10000,0,this);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==PERMS_CALL_ID){
           checkPermssions();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Lm !=null){
            Lm.removeUpdates(this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double lattitude= location.getLatitude();
        double longitude= location.getLongitude();

        Toast.makeText(this, "Localisation:"+lattitude+"/"+longitude, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
