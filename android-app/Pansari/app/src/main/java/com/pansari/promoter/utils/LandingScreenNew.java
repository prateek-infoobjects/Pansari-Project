package com.pansari.promoter.utils;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.location.LocationRequest;
import com.pansari.promoter.LoginActivity;
import com.pansari.promoter.R;
import com.pansari.promoter.data.PrefManager;
import com.pansari.promoter.locationModule.LocationUpdateService;
import com.pansari.promoter.salesmodule.SalesPageOne;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LandingScreenNew extends BaseActivity implements View.OnClickListener
       {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 111;
    private ImageView logoutBtn;
    private PrefManager mPrefManager;
    LocationManager locationManager;
    private LocationUpdateService mService;
    private boolean mBound;
//    public BackgroundService gpsService;
//    public boolean mTracking = false;
//
//    private ServiceConnection serviceConnection = new ServiceConnection() {
//        public void onServiceConnected(ComponentName className, IBinder service) {
//            String name = className.getClassName();
//            if (name.endsWith("BackgroundService")) {
//                gpsService = ((BackgroundService.LocationServiceBinder) service).getService();
////                btnStartTracking.setEnabled(true);
////                txtStatus.setText("GPS Ready");
//            }
//        }
//
//        public void onServiceDisconnected(ComponentName className) {
//            if (className.getClassName().equals("BackgroundService")) {
//                gpsService = null;
//            }
//        }
//    };
    private TextView welcome_area;
    private AppButton salesBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationContext().registerComponentCallbacks(this);
        setContentView(R.layout.landing_screen);
        mPrefManager = new PrefManager(this);
        initViews();

//        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//
// Define a listener that responds to location updates

//        final Intent intent = new Intent(this.getApplication(), BackgroundService.class);
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

// Register the listener with the Location Manager to receive location updates
//        if (!checkForPermission()){
//
//            // permission granted
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    setGoogleApiClient();
////                gpsService.startTracking();
////                mTracking = true;
//                }
//            }, 5000);
//        }


//
//        setGoogleApiClient();
//        mService.requestLocationUpdates();
//        locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
//                this);
    }

    private boolean askPermisssionOld() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                ActivityCompat.requestPermissions(LandingScreenNew.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1000 && resultCode == RESULT_OK) {
//            gpsService.startTracking(locationRequest);
//            mTracking = true;
//        }
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mTracking) {
//            mTracking = false;
//            gpsService.stopTracking();
//            unbindService(serviceConnection);
//        }
//
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        //Request location updates:
//                        setGoogleApiClient();
//                        gpsService.startTracking();
//                        mTracking = true;
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return;
            }

        }
    }

    private void makeUseOfNewLocation(Location location) {


    }

    private void initViews() {
        logoutBtn = findViewById(R.id.logout);
        welcome_area = findViewById(R.id.welcome_name);
        logoutBtn.setOnClickListener(this);
        salesBtn = findViewById(R.id.sales_btn);
        salesBtn.setOnClickListener(this);

        welcome_area.setText("Welcome " + mPrefManager.getUserName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logout:
                logout();
                break;
            case R.id.sales_btn:
                gotToSalesPage();
                break;
        }
    }

    private void gotToSalesPage() {
        Intent sales = new Intent(this, SalesPageOne.class);
        startActivity(sales);
    }

    private void logout() {
        Dialog dialog = AppUtils.showDialog(this, "Logout", "Do you want to logout?",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        mPrefManager.setUserAsLogin(false);
                        mPrefManager.saveUserId("");

//                        mTracking = false;
//                        gpsService.stopTracking();
//                        unbindService(serviceConnection);
                        ((PansariApplication) LandingScreenNew.this.getApplicationContext()).stopConnection();

                        Intent login = new Intent(LandingScreenNew.this, LoginActivity.class);
                        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(login);
                        finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        dialog.show();

    }

//    @Override
//    public void onLocationChanged(Location location) {
//        Log.d("location >>> ", location.getLatitude() + " " + location.getLongitude());
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
////        locationManager.removeUpdates(this);
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }

    LocationRequest locationRequest;

//    private void setGoogleApiClient() {
//        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this).build();
//        googleApiClient.connect();
//
//        locationRequest = LocationRequest.create();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(60 * 1000);
//        locationRequest.setFastestInterval(60 * 1000);
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(locationRequest);
//
//        //**************************
//        builder.setAlwaysShow(true); //this is the key ingredient
//        //**************************
//
//        PendingResult<LocationSettingsResult> result =
//                LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
//        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
//            @Override
//            public void onResult(@NonNull LocationSettingsResult result) {
//                final Status status = result.getStatus();
////                final LocationSettingsStates state = result.getLocationSettingsStates();
//
//                switch (status.getStatusCode()) {
//                    case LocationSettingsStatusCodes.SUCCESS:
//                        // already location is on
//                        gpsService.startTracking(locationRequest);
//                        mTracking = true;
//                        break;
//                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                        // Location settings are not satisfied. But could be fixed by showing the user
//                        // a dialog.
//                        try {
//                            // Show the dialog by calling startResolutionForResult(),
//                            // and check the result in onActivityResult().
//                            status.startResolutionForResult(
//                                    LandingScreenNew.this, 1000);
//                        } catch (IntentSender.SendIntentException e) {
//                            // Ignore the error.
//                        }
//                        break;
//                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                        break;
//                }
//            }
//        });
//    }

//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }


}
