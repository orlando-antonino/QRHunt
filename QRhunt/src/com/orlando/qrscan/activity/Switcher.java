package com.orlando.qrscan.activity;

import com.orlando.qrscan.R;
import com.orlando.qrscan.R.layout;
import com.orlando.qrscan.R.menu;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

public class Switcher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_switcher);
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sliding, menu);
		return true;
	}

}
