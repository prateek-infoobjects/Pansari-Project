package com.pansari.promoter.data;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private SharedPreferences sharedPref;
    private Context context;

    public PrefManager(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences("app_pref_pansari", Context.MODE_PRIVATE);
    }

    public boolean isUserLogin() {
        return sharedPref.getBoolean("isUserLogin", false);
    }

    public void setUserAsLogin(boolean loginStatus) {
        sharedPref.edit().putBoolean("isUserLogin", loginStatus).commit();

    }

    public void saveUserId(String id) {
        sharedPref.edit().putString("user_id", id).commit();
    }

    public String getUserId() {
        return sharedPref.getString("user_id", "");
    }

    public void saveUserName(String id) {
        sharedPref.edit().putString("user_name", id).commit();
    }

    public String getUserName() {
        return sharedPref.getString("user_name", "");
    }
}
