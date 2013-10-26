package com.chernicka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Sov on 26.10.13.
 */
public class SplashActivity extends Activity {

    public boolean loged;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_lay);
        loged = true;
        View parent = findViewById(R.id.splash_lay);
        parent.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loged) {
                    startActivity(new Intent(SplashActivity.this, RegistrationActivity.class));
                    finish();
                }
            }
        }, 500);

    }

    @Override
    protected void onPause() {
        loged = false;
        super.onPause();
    }
}