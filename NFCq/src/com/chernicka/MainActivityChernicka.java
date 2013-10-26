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

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivityChernicka extends Activity implements OnClickListener,
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener {
	private MapFragment mapFragment;
	private SlidingMenu menu;
	private Button btnStart;
	Location mCurrentLocation;
	private LocationClient mLocationClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		
		mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
		mLocationClient = new LocationClient(this, this, this);
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(this);

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
			
			// TODO send id and location to server
			// ON complete wait for opponent, request every 30 seconds
			// ON opponent ready do:
			//Intent intent = new Intent(getApplicationContext(),BeamActivity.class);
			//intent.putExtra(, value)
			//startActivity(intent);
			break;

		default:
			break;
		}
	}
	
    @Override
    protected void onStart() {
        super.onStart();
        // Connect the client.
        mLocationClient.connect();
        
    }

    /*
     * Called when the Activity is no longer visible.
     */
    @Override
    protected void onStop() {
        // Disconnecting the client invalidates it.
        mLocationClient.disconnect();
        super.onStop();
    }

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		mCurrentLocation = mLocationClient.getLastLocation();
		Toast.makeText(getApplicationContext(), "Location acquired", Toast.LENGTH_LONG).show();
		btnStart.setEnabled(true);
		Log.i("Getted Location"," "+mCurrentLocation.getLatitude() +" ^ "+ mCurrentLocation.getLongitude());
		//LatLng latLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
	    
		//mapFragment.getMap().moveCamera(CameraUpdateFactory.newLatLng(latLng));
		//mapFragment.getMap().animateCamera(CameraUpdateFactory.newLatLng(latLng));
	}

	@Override
	public void onDisconnected() {
		
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main_activity_chernicka, menu);
	// return true;
	// }

}
