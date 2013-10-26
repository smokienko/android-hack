package com.example.fragmentsimplestapp.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chernicka.R;


/**
 * Created by Anna on 26.10.13.
 */
class InfoFragment extends DialogFragment {
    private final String title;
    private final String message;
    private Activity activity;

    InfoFragment(String title, String message, Activity activity) {
        this.title = title;
        this.message = message;
        this.activity = activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.info, null);
        if (!TextUtils.isEmpty(title)) {
            ((TextView)view.findViewById(R.id.info_title)).setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            ((TextView)view.findViewById(R.id.info_msg)).setText(message);
        }
        alertDialogBuilder.setView(view);
        return alertDialogBuilder.create();
    }
}