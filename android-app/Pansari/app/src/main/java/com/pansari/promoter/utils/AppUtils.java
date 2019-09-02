package com.pansari.promoter.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

import com.pansari.promoter.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {

    public static boolean isEmptyString(String text) {
        return (text == null || text.trim().equals("null") || text.trim()
                .length() <= 0);
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static DisplayMetrics getDeviceMetrics(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return metrics;
    }

    public static AlertDialog showDialog(Context context, String title, String message,
                                         DialogInterface.OnClickListener clickListener) {
        AlertDialog.Builder alertDailogBuilder = new AlertDialog.Builder(context);
        alertDailogBuilder.setTitle(title);
        alertDailogBuilder.setMessage(message);

        alertDailogBuilder.setPositiveButton("OK", clickListener);


        return alertDailogBuilder.create();
    }

    public static AlertDialog showDialog(Context context, String title, String message,
                                         DialogInterface.OnClickListener clickListener, DialogInterface.OnClickListener nclickListener) {
        AlertDialog.Builder alertDailogBuilder = new AlertDialog.Builder(context);
        alertDailogBuilder.setTitle(title);
        alertDailogBuilder.setMessage(message);

        alertDailogBuilder.setPositiveButton("OK", clickListener);
        alertDailogBuilder.setNegativeButton("Cancel", nclickListener);


        return alertDailogBuilder.create();
    }

    /**
     * Checking if a String matches desired Regex pattern. Used for validating
     * emails.
     */

    public static boolean isMatch(String text, String pattern) {
        try {
            Pattern patt = Pattern.compile(pattern);
            Matcher matcher = patt.matcher(text);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static boolean isValid(String name) {
        if (name != null && !name.equalsIgnoreCase("null")
                && !name.equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }

    public static ProgressDialog createProgressDialog(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext, R.style.NewDialog);
        try {
//            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
        dialog.setCancelable(false);
//        dialog.addContentView(new ProgressBar(mContext), new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT));
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.setContentView(R.layout.progress_dialog_layout);
        return dialog;
    }

    public static ProgressDialog createProgressMultipleCalls(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext, R.style.Theme_AppCompat_Dialog);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.progress_dialog_layout);
        return dialog;
    }

    static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting_locaction_updates";

    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The {@link Context}.
     */
    public static boolean requestingLocationUpdates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false);
    }

    /**
     * Stores the location updates state in SharedPreferences.
     *
     * @param requestingLocationUpdates The location updates state.
     */
    public static void setRequestingLocationUpdates(Context context, boolean requestingLocationUpdates) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply();
    }

    /**
     * Returns the {@code location} object as a human readable string.
     *
     * @param location The {@link Location}.
     */
    static String getLocationText(Location location) {
        return location == null ? "Unknown location" :
                "(" + location.getLatitude() + ", " + location.getLongitude() + ")";
    }

//    static String getLocationTitle(Context context) {
//        return context.getString(R.string.location_updated,
//                DateFormat.getDateTimeInstance().format(new Date()));
//    }
}
