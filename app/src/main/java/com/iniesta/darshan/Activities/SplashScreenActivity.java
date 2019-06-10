package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.iniesta.darshan.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        checkAndRunActivityForFirstTime();

    }

    public void checkAndRunActivityForFirstTime() {

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {

            //show app Intro Activity For First Time
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent splashScreen = new Intent(SplashScreenActivity.this, SliderScreenActivity.class);
                    startActivity(splashScreen);
                    finish();
                }
            },2000);
            Toast.makeText(SplashScreenActivity.this, "First Run", Toast.LENGTH_LONG).show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
        } else {
            // otherwise Show Direct Home Activity
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent splashScreen = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(splashScreen);
                    finish();
                }
            },2000);
        }

    }
}
