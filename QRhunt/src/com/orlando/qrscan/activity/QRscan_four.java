package com.orlando.qrscan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orlando.qrscan.R;

public class QRscan_four extends Fragment {
	
	TextView formatResultTxt4;
	TextView valResultTxt4;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_qrscan_four , container, false);

		return rootView;
	}
	@Override
	public void onResume() {
		super.onResume();
		
		int prog = ClueManager.getProgress();
		if (prog ==5){
			TextView mTag4NotFound = (TextView) getView().findViewById(R.id.tag_4_notfound_marker);
			mTag4NotFound.setVisibility(TextView.GONE);
			ImageView mTag4Found = (ImageView) getView().findViewById(R.id.tag_4_found_marker);
			mTag4Found.setVisibility(View.VISIBLE);
			ImageView mTag4NextFound = (ImageView) getView().findViewById(R.id.tag_4_next);
			mTag4NextFound.setVisibility(View.VISIBLE);
		}
		
	}
	public void setText(String scanContent, String scanType) {
	     formatResultTxt4 = (TextView) getView().findViewById(R.id.textType2);
	     valResultTxt4  = (TextView) getView().findViewById(R.id.textResult2);

	     formatResultTxt4.setText(scanType);
	     valResultTxt4.setText(scanContent);
	     
	}
	

}
