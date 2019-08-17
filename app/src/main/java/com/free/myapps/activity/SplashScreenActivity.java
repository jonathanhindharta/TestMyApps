package com.free.myapps.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.free.myapps.R;

public class SplashScreenActivity extends AppCompatActivity {
    private long ms=0;
    //waktu tayang splashscreen 3000 millisecond = 3 detik
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    finish();
                    startActivity(i);
            }
        }, 3000);
    }
}
