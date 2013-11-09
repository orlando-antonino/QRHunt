package com.orlando.qrscan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orlando.qrscan.R;

public class QRscan_sec extends Fragment {
	
	TextView formatResultTxt2;
	TextView valResultTxt2;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_qrscan_sec , container, false);

		return rootView;
	}
	@Override
	public void onResume() {
		super.onResume();
		
		int prog = ClueManager.getProgress();
		if (prog ==3){
			TextView mTag2NotFound = (TextView) getView().findViewById(R.id.tag_2_notfound_marker);
			mTag2NotFound.setVisibility(TextView.GONE);
			ImageView mTag2Found = (ImageView) getView().findViewById(R.id.tag_2_found_marker);
			mTag2Found.setVisibility(View.VISIBLE);
			ImageView mTag2NextFound = (ImageView) getView().findViewById(R.id.tag_2_next);
			mTag2NextFound.setVisibility(View.VISIBLE);
		}
		
	}
	public void setText(String scanContent, String scanType) {
//	     formatResultTxt2 = (TextView) getView().findViewById(R.id.textType2);
	     valResultTxt2  = (TextView) getView().findViewById(R.id.textResult2);

	     formatResultTxt2.setText(scanType);
	     valResultTxt2.setText(scanContent);
	     
	}
	

}
