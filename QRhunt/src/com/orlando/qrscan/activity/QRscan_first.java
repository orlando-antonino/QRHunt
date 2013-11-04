package com.orlando.qrscan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orlando.qrscan.R;

public class QRscan_first extends Fragment {
	
	TextView formatResultTxt;
	TextView valResultTxt;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_qrscan_first , container, false);

		return rootView;
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		
		int prog = ClueManager.getProgress();
		if (prog ==2){
			TextView mTag1NotFound = (TextView) getView().findViewById(R.id.tag_1_notfound_marker);
			mTag1NotFound.setVisibility(TextView.GONE);
			ImageView mTag1Found = (ImageView) getView().findViewById(R.id.tag_1_found_marker);
			mTag1Found.setVisibility(View.VISIBLE);
			ImageView mTag1NextFound = (ImageView) getView().findViewById(R.id.tag_1_next);
			mTag1NextFound.setVisibility(View.VISIBLE);
		}
		
	}

	public void setText(String scanContent, String scanType) {
	     formatResultTxt = (TextView) getView().findViewById(R.id.textType);
	     valResultTxt  = (TextView) getView().findViewById(R.id.textResult);

	     formatResultTxt.setText(scanType);
	     valResultTxt.setText(scanContent);
	     
	}
	

}
