package com.orlando.qrscan.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.Toast;

import com.orlando.qrscan.R;

public class Switcher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_switcher);

		final String barcode = getApplicationContext().getResources()
				.getString(R.string.barcode_app);
		final String url_barcode = getApplicationContext().getResources()
				.getString(R.string.url_barcode);
		
		boolean check_bscann_installed =true; 
		
		//Check for emulator
		if ((android.os.Build.MODEL.equals("google_sdk"))
				|| (android.os.Build.MODEL.equals("sdk"))) {
			Toast.makeText(
					this,
					"You must install Google Play store from Google App to install Barcode Scanner",
					Toast.LENGTH_LONG).show();
			check_bscann_installed = false;
		} 
		
		PackageManager mPm = getPackageManager(); // 1

		boolean app_installed = false;
		try {
			mPm.getPackageInfo(barcode, PackageManager.GET_ACTIVITIES);
			app_installed = true;

		} catch (NameNotFoundException e1) {
			app_installed = false;
			// e1.printStackTrace();
		}

		if (!app_installed && check_bscann_installed) {

			Uri marketUri = Uri.parse(url_barcode);
			Intent playStoreIntent = new Intent(Intent.ACTION_VIEW, marketUri);
			startActivity(playStoreIntent);
			finish();

		} else {
			SharedPreferences appSharedPrefs = PreferenceManager
					.getDefaultSharedPreferences(getApplicationContext());
			boolean intro_seen = appSharedPrefs.getBoolean("seen_intro", false);

			if (!intro_seen) {
				Intent intent;
				intent = new Intent(this, Sliding.class);
				startActivity(intent);
				finish();
			} else {
				Intent intent;
				intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sliding, menu);
		return true;
	}

}
