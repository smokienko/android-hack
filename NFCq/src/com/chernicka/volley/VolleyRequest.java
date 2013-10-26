package com.chernicka.volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.AndroidAuthenticator;
import com.android.volley.toolbox.JsonObjectRequest;
import com.chernicka.NfcQAplication;
import com.chernicka.model.User;

import org.json.JSONObject;

/**
 * Created by Sov on 26.10.13.
 */
public class VolleyRequest {

    private static final String LOGIN = "http://etc.pp.ua/?a=reg&login={0}&password={1}";


    private static void addGetRequest(String url,final VolleyResponse listener){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url, null,listener,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(new Exception(error.getMessage()));
            }
        });
        NfcQAplication.getVolleyQueue().add(request);
    }

    private static void addPostRequest(String url, final VolleyResponse listener){
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,url,null,listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(new Exception(error.getMessage()));
            }
        });
        NfcQAplication.getVolleyQueue().add(request);
    }

    public static void loginUser(User user, VolleyResponse listener){
        String url = String.format(LOGIN,user.getName(),user.getPass());
        addPostRequest(url,listener);
    }


}
