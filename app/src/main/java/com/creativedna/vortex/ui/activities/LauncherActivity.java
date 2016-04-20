package com.creativedna.vortex.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.creativedna.vortex.R;


public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_view);

        startActivity(new Intent(getBaseContext(), SplashActivity.class));

        finish();
    }
}
