package com.pansari.promoter.NetworkInteractors;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;

import com.pansari.promoter.locationModule.LocationResultHelper;
import com.google.android.gms.location.LocationResult;

import java.util.List;

public class LocationUpdateInetntService extends IntentService {
    public static String ACTION_PROCESS_UPDATES = "location_process";
    private Context mContext;

    public LocationUpdateInetntService(){
        super("");

    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public LocationUpdateInetntService(String name, Context context) {
        super(name);
        mContext = context;
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_PROCESS_UPDATES.equals(action)) {
                LocationResult result = LocationResult.extractResult(intent);
                if (result != null) {
                    List<Location> locations = result.getLocations();
                    LocationResultHelper locationResultHelper = new LocationResultHelper(
                            this, locations);
                    // Save the location data to SharedPreferences.
//                    locationResultHelper.saveResults();
//                    // Show notification with the location data.
//                    locationResultHelper.showNotification();
//                    Log.i(TAG, LocationResultHelper.getSavedLocationResult(context));
                }
            }
        }
    }
}
