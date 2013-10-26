package com.chernicka;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.chernicka.model.Task;
import com.chernicka.model.User;

/**
 * Created by Sov on 26.10.13.
 */
public class NfcQAplication extends Application {

    private static RequestQueue volleyQueue;
    private static User user;
    private static Task currentTask;

    @Override
    public void onCreate() {
        super.onCreate();
        volleyQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getVolleyQueue() {
        return volleyQueue;
    }

    public static User getUser() {
        return user;
    }

    public static Task getCurrentTask() {
        return currentTask;
    }

    public static void setUser(User user) {
        NfcQAplication.user = user;
    }

    public static void setCurrentTask(Task currentTask) {
        NfcQAplication.currentTask = currentTask;
    }
}
