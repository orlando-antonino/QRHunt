package com.orlando.qrscan.activity;

import com.orlando.qrscan.R;
import com.orlando.qrscan.R.layout;
import com.orlando.qrscan.R.menu;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;

public class Sliding extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sliding);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sliding, menu);
		return true;
	}
	public void CloseSlide(View v){
		SharedPreferences appSharedPrefs = PreferenceManager
	      		  .getDefaultSharedPreferences(getApplicationContext());
		Editor prefsEditor = appSharedPrefs.edit();			
		prefsEditor.putBoolean("seen_intro", true);
        prefsEditor.commit();
        
        Intent intent;
		intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
