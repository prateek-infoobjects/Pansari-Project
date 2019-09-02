package com.pansari.promoter.locationModule;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.util.Log;

import java.util.List;

import androidx.core.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class LocationResultHelper {

    private final List<Location> mLocations;
    private final Context mContext;
    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_CHANNEL_ID = "notification_channel";
    private final NotificationCompat.Builder notification;


    public LocationResultHelper(Context context, List<Location> locations) {
        mContext = context;
        mLocations = locations;
        notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        Log.d("getting location >>",locations.get(0).getLatitude()+" "+locations.get(0).getLongitude());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(false);
            nm.createNotificationChannel(notificationChannel);
        }
        notification.setSmallIcon(android.R.drawable.ic_notification_overlay);
        notification.setTicker("Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Locations Update");
        notification.setContentText(locations.get(0).getLatitude()+" "+locations.get(0).getLongitude());
        notification.setChannelId(NOTIFICATION_CHANNEL_ID);
        notification.build();

//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.setContentIntent(pendingIntent);

        nm.notify(NOTIFICATION_ID, notification.build());
    }

}
