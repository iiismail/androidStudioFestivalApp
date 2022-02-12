package com.example.huddscharityrowingcompetitionv1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler splashHandler = new Handler();
        splashHandler.postDelayed(this,4000);

    }

    @Override
    public void run() {
        Intent intent = new Intent (SplashScreen.this, DetailActivity.class);
        SplashScreen.this.startActivity( intent );
        finish();
    }
}
