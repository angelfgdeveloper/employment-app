package com.angelfgdeveloper.manresapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.angelfgdeveloper.manresapp.R;
import com.angelfgdeveloper.manresapp.helpers.Constants;

public class SplashActivity extends AppCompatActivity {

    private boolean isClosedPreview = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        init();
    }

    private void init() {
        Bundle args = getIntent().getExtras();
        if(args != null){
            isClosedPreview = args.getBoolean(Constants.IS_CLOSED_PREVIEW_TIME);
        }

        if (isClosedPreview) {
            delayTime(300);
        } else {
            delayTime(1000);
        }
    }

    private void delayTime(int delayMillis) {
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, delayMillis);
    }
}