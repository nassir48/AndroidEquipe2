package com.go.by.ter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_localisation );
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onResume() {
        super.onResume ();
        Lm = (LocationManager) getSystemService ( LOCATION_SERVICE );
        if (Lm.isProviderEnabled ( LocationManager.GPS_PROVIDER )) {
            if (checkSelfPermission ( Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission ( Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            Lm.requestLocationUpdates ( LocationManager.GPS_PROVIDER, 1000, 0, this );
        }
        if (Lm.isProviderEnabled ( LocationManager.PASSIVE_PROVIDER )){
            Lm.requestLocationUpdates ( LocationManager.PASSIVE_PROVIDER,1000, 0,this);
        }
        if (Lm.isProviderEnabled ( LocationManager.NETWORK_PROVIDER )){
            Lm.requestLocationUpdates ( LocationManager.NETWORK_PROVIDER,1000, 0,this);
        }
    }
    protected void onPause(){
        super.onPause ();
        if (Lm != null){
            Lm.removeUpdates ( this );
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double laltitude =location.getAltitude ();
        double longititude =location.getLongitude ();
        Toast.makeText ( this,"Loacation:"+laltitude+ "/"+ longititude,Toast.LENGTH_LONG ).show ();

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
