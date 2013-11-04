/*
 * Copyright 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.orlando.qrscan.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.actionbar.ActionBarActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.orlando.qrscan.R;

public class MainActivity extends ActionBarActivity {
	private static final String ME = "com.orlando.qrscan.activity.MainActivity";

	private FragmentManager fragmentManager = null;
	private static final String barcodePackgName = "com.google.zxing.client.android";
	QRscan_first qr_first = null;
	QRscan_sec qr_sec = null;
	QRscan_th qr_th = null;
	QRscan_four qr_four = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
//		PackageManager mPm = getPackageManager();  // 1
//		PackageInfo info;
//		try {
//			info = mPm.getPackageInfo(barcodePackgName, 0);
//			if (info == null){
//				Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
//				Intent playStoreIntent = new Intent(Intent.ACTION_VIEW,marketUri);
//			    startActivity(playStoreIntent);
//			    super.finish();
//			}
//		} catch (NameNotFoundException e1) {
//			
//			e1.printStackTrace();
//		}  
		
		
		
		ClueManager.initClueManager(getApplicationContext());
		fragmentManager = getSupportFragmentManager();

		int prog = ClueManager.getProgress();
		switch (prog) {
		case 1:
			try {
				qr_first = new QRscan_first();

				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"first", qr_first, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "first" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		case 2:
			try {
				qr_sec = new QRscan_sec();

				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"sec", qr_sec, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "sec" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		case 3:
			try {
				qr_th = new QRscan_th();

				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"th", qr_th, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "th" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
			
		case 4:
			try {
				qr_four = new QRscan_four();

				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"four", qr_four, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "four" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		default:
			break;
		}

	}

	public void nextFrag(View v) {
		int prog = ClueManager.getProgress();
		
		switch (prog) {
		case 2:
			try {
				qr_sec = new QRscan_sec();
				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"sec", qr_sec, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "sec" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		case 3:
			try {
				qr_th = new QRscan_th();
				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"th", qr_th, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "th" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		case 4:
			try {
				qr_four = new QRscan_four();

				boolean res = FragmentHandler.replaceFragment(fragmentManager,
						"four", qr_four, R.id.content_frame);
				Log.i("Main", "fRAGMENT " + "four" + " INSERITO: " + res);
			} catch (Exception e) {
				e.printStackTrace();
				finish();
			}
			break;
		default:
			break;
		}
		
	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {

		IntentResult scanningResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);

		if (scanningResult != null) {
			String scanContent = scanningResult.getContents();
			// String scanType = scanningResult.getFormatName();
//			scanContent = "http://qrscan.dne/?c=firstclue";
			showToast(scanContent);

			ClueManager.setProgress(scanContent);
		} else
			showToast("no scan result");

	}

	public void showToast(String strMessage) {
		Toast toast = Toast.makeText(getApplicationContext(), strMessage,
				Toast.LENGTH_SHORT);
		toast.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "Qr Scan", Toast.LENGTH_SHORT).show();
			break;
		case R.id.scan:
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
			break;
		default:
			break;
		// case R.id.menu_refresh:
		// Toast.makeText(this, "Fake refreshing...",
		// Toast.LENGTH_SHORT).show();
		// getActionBarHelper().setRefreshActionItemState(true);
		// getWindow().getDecorView().postDelayed(
		// new Runnable() {
		// @Override
		// public void run() {
		// getActionBarHelper().setRefreshActionItemState(false);
		// }
		// }, 1000);
		// break;
		//

		//
		// case R.id.menu_share:
		// Toast.makeText(this, "Tapped share", Toast.LENGTH_SHORT).show();
		// break;
		}
		return super.onOptionsItemSelected(item);
	}
}
