package com.pansari.promoter.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.location.LocationRequest;
import com.pansari.promoter.locationModule.BackgroundService;

public class PansariApplication extends Application implements Application.ActivityLifecycleCallbacks {

    public BackgroundService gpsService;
    public boolean mTracking = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            String name = className.getClassName();
            if (name.endsWith("BackgroundService")) {
                gpsService = ((BackgroundService.LocationServiceBinder) service).getService();
//                btnStartTracking.setEnabled(true);
//                txtStatus.setText("GPS Ready");
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            if (className.getClassName().equals("BackgroundService")) {
                gpsService = null;
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        final Intent intent = new Intent(this, BackgroundService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }


    public void startTracking(LocationRequest locationRequest) {
        if (!mTracking) {
            gpsService.startTracking(locationRequest);
            mTracking = true;
        }

    }

    public void stopConnection() {
        mTracking = false;
        gpsService.stopTracking();
        unbindService(serviceConnection);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.d("activity created", activity.getComponentName().getClassName());
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            Log.d("activity destroy", activity.getComponentName().getClass().getName());
        } else {
            Log.d("activity destroy", "all");
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity != null) {
            Log.d("activity destroy", activity.getComponentName().getClass().getName());
        } else {
            Log.d("activity destroy", "all");
        }
    }
}
