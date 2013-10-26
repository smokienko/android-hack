package com.chernicka;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sov on 26.10.13.
 */
public class NfcQAplication extends Application {

    private static RequestQueue volleyQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        volleyQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getVolleyQueue() {
        return volleyQueue;
    }
}
