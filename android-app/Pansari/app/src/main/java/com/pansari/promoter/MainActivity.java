package com.pansari.promoter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.pansari.promoter.data.PrefManager;
import com.pansari.promoter.utils.LandingScreenNew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    PrefManager prefManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager=new PrefManager(this);

        loadMainApplication();
    }

    private void loadMainApplication() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                //check if app domain is set or not
                if (prefManager.isUserLogin()) {
                    Intent flow = new Intent(MainActivity.this, LandingScreenNew.class);
                    startActivity(flow);
                    MainActivity.this.finish();
                } else {
                    Intent flow = new Intent(MainActivity.this, LoginActivity.class);

                    flow.putExtra("checkForRestart", true);
                    startActivity(flow);
                    MainActivity.this.finish();
                }
            }
        }, 3000);
    }
}
