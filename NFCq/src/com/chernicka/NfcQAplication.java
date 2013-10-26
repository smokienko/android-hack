package com.chernicka;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sov on 26.10.13.
 */
public class NfcQAplication extends Application {

    private RequestQueue volleyQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        volleyQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getVolleyQueue() {
        return volleyQueue;
    }
}
