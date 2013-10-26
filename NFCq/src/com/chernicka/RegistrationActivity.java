package com.chernicka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chernicka.model.User;
import com.chernicka.volley.VolleyRequest;
import com.chernicka.volley.VolleyResponse;

import org.json.JSONObject;

/**
 * Created by Anna on 26.10.13.
 */
public class RegistrationActivity extends Activity implements View.OnClickListener{

    private final String TAG = RegistrationActivity.class.getSimpleName();
    private EditText login;
    private EditText password;
    private EditText passwordConfirm;
    private Button btnSubmit;
    private User user;

    private VolleyResponse responseListener = new VolleyResponse() {
        @Override
        public void onError(Exception error) {
            Log.d(TAG,error.getMessage());
        }

        @Override
        public void onResponse(JSONObject response) {
            try {
                user.setUserDataFromJson(response);
                NfcQAplication.setUser(user);
                startActivity(new Intent(RegistrationActivity.this, MainActivityChernicka.class));
            } catch (Exception ex){
                onError(ex);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User();
        setContentView(R.layout.registration);
        login = (EditText)findViewById(R.id.login);
        password = (EditText)findViewById(R.id.password);
        passwordConfirm = (EditText)findViewById(R.id.password_confirm);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String loginValue = login.getText().toString();
        String passwordValue = password.getText().toString();
        String confirmationValue = passwordConfirm.getText().toString();

        if (TextUtils.isEmpty(loginValue)) {
            Log.d(TAG, "Please, fil in login");
        }

        if (TextUtils.isEmpty(passwordValue)) {
            Log.d(TAG, "Please, fil in password");
        }

        if (TextUtils.isEmpty(confirmationValue)) {
            Log.d(TAG, "Please, confirm your password");
        }

        if (passwordValue.equals(confirmationValue)) {
            user.setName(loginValue);
            user.setPass(passwordValue);
            VolleyRequest.loginUser(user,responseListener);
//            Log.d(TAG, "send login: " + loginValue +" password: " + passwordValue);

        }
    }
}
