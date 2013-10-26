package com.chernicka;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.chernicka.model.Task;
import com.chernicka.model.User;
import com.chernicka.volley.VolleyRequest;
import com.chernicka.volley.VolleyResponse;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.MapFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import org.json.JSONObject;

public class MainActivityChernicka extends Activity implements OnClickListener,GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener{
	private MapFragment mapFragment;
	private SlidingMenu menu ;
	private Button btnStart;
    private LocationClient mLocationClient;
    private Location mCurrentLocation;

    private User user;

    private int timesToRequest = 0;

    private static final int TIMEOU = 15000;

    private VolleyResponse playResponse = new VolleyResponse() {
        int i = 0;

        @Override
        public void onError(Exception error) {
            if (timesToRequest  < 10){
                timesToRequest ++;
                menu.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        VolleyRequest.registerForQuest(user,playResponse);
                    }
                },TIMEOU);
            } else {
                MainActivityChernicka.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("MainActivityChernicka","no user avaliable");
                        timesToRequest = 0;
                    }
                });
            }
        }

        @Override
        public void onResponse(JSONObject response) {
            Task task = new Task();
            Log.d("onResponse",response.toString());
            try {
                task.setTaskQuestionFromJson(response);
                NfcQAplication.setCurrentTask(task);
                timesToRequest = 0;
                Intent intent = new Intent(getApplicationContext(), BeamActivity.class);
                startActivity(intent);
            } catch (Exception ex){
                onError(ex);
            }

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        // Connect the client.
        mLocationClient.connect();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = NfcQAplication.getUser();
        setContentView(R.layout.activity_main_activity_chernicka);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);
        
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        mLocationClient = new LocationClient(this, this, this);
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			menu.toggle();
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnStart:

            VolleyRequest.registerForQuest(user,playResponse);

			break;

		default:
			break;
		}
	}

    @Override
    public void onConnected(Bundle bundle) {
        mCurrentLocation = mLocationClient.getLastLocation();
        Toast.makeText(getApplicationContext(), "Location acquired", Toast.LENGTH_LONG).show();
        btnStart.setEnabled(true);
        user.setLongtitude(mCurrentLocation.getLongitude());
        user.setLatitude(mCurrentLocation.getLatitude());
        Log.i("Getted Location", " " + mCurrentLocation.getLatitude() + " ^ " + mCurrentLocation.getLongitude());
    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_activity_chernicka, menu);
//        return true;
//    }
    
}
