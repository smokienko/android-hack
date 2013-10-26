package com.chernicka.volley;

import com.android.volley.Response;

import org.json.JSONObject;

/**
 * Created by Sov on 26.10.13.
 */
public interface VolleyResponse extends Response.Listener<JSONObject> {

    public void onError(Exception error);


}
