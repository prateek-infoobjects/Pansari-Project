package com.pansari.promoter.locationModule;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.pansari.promoter.NetworkInteractors.TrackingDataController;
import com.pansari.promoter.NetworkInteractors.TrackingViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class BackgroundService extends Service implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener, TrackingViewModel {
    private static final String CHANNEL_ID = "channel_id";
    private final LocationServiceBinder binder = new LocationServiceBinder();
    private final String TAG = "BackgroundService";
    private LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private NotificationManager notificationManager;

    private final int LOCATION_INTERVAL = 500;
    private final int LOCATION_DISTANCE = 10;
    private NotificationCompat.Builder notification;
    private Location mLastLocation;
    private TrackingDataController trackingController;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

//    private class LocationListener implements android.location.LocationListener
//    {
//        private Location lastLocation = null;
//        private final String TAG = "LocationListener";
//        private Location mLastLocation;
//
//        public LocationListener(String provider)
//        {
//            mLastLocation = new Location(provider);
//        }
//
//        @Override
//        public void onLocationChanged(Location location)
//        {
//            mLastLocation = location;
//            Log.i(TAG, "LocationChanged: "+location);
//        }
//
//        @Override
//        public void onProviderDisabled(String provider)
//        {
//            Log.e(TAG, "onProviderDisabled: " + provider);
//        }
//
//        @Override
//        public void onProviderEnabled(String provider)
//        {
//            Log.e(TAG, "onProviderEnabled: " + provider);
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras)
//        {
//            Log.e(TAG, "onStatusChanged: " + status);
//        }
//    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        Log.i(TAG, "LocationChanged: " + location);
        if(trackingController!=null){
            trackingController.trackLocation(location.getLatitude(),location.getLongitude());
        }
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.e(TAG, "onProviderDisabled: " + provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.e(TAG, "onProviderEnabled: " + provider);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.e(TAG, "onStatusChanged: " + status);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        startForeground(12345678, getNotification());
        trackingController=new TrackingDataController(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLocationManager != null) {
            try {
                mLocationManager.removeUpdates(mLocationListener);
            } catch (Exception ex) {
                Log.i(TAG, "fail to remove location listners, ignore", ex);
            }
        }
    }



    public void startTracking(LocationRequest locationRequest) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        getFusedLocationProviderClient(this).requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        // do work here
                        onLocationChanged(locationResult.getLastLocation());
                    }
                },
                Looper.myLooper());
//        setGoogleApiClient();
//        initializeLocationManager();
//        mLocationListener = new LocationListener(LocationManager.GPS_PROVIDER);
//
//        try {
//            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_INTERVAL, LOCATION_DISTANCE, mLocationListener);
//
//        } catch (java.lang.SecurityException ex) {
//            // Log.i(TAG, "fail to request location update, ignore", ex);
//        } catch (IllegalArgumentException ex) {
//            // Log.d(TAG, "gps provider does not exist " + ex.getMessage());
//        }

    }

    public void stopTracking() {
        this.onDestroy();
    }

    private Notification getNotification() {
        notification = new NotificationCompat.Builder(this, CHANNEL_ID);
        notification.setAutoCancel(true);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "My Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(false);
            nm.createNotificationChannel(notificationChannel);
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), CHANNEL_ID).setAutoCancel(true);
            return builder.build();
        }

        notification.setSmallIcon(android.R.drawable.ic_notification_overlay);
        notification.setTicker("Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Locations Update");

        return notification.build();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void dataSentSuccessfuly() {

    }

    @Override
    public void errorInSendingData() {

    }


    public class LocationServiceBinder extends Binder {
        public BackgroundService getService() {
            return BackgroundService.this;
        }
    }

}
