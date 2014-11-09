package com.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* Use the LocationManager class to obtain GPS locations */
		LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener locListener = new MyLocationListener();
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				locListener);
	}


	public class MyLocationListener implements LocationListener {
		TextView myGPS = (TextView) findViewById(R.id.textGPS);

		@Override
		public void onLocationChanged(Location loc) {
			double myLatitude = loc.getLatitude();
			double myLongitude = loc.getLongitude();
			String Text = "Latitude = " + myLatitude	+ "\nLongitude = " + myLongitude;

			myGPS.setText(Text);
		}

		@Override
		public void onProviderDisabled(String provider) {
			
		}

		@Override
		public void onProviderEnabled(String provider) {
		
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {

		}
	}
}
