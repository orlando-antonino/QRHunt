package com.orlando.qrscan.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orlando.qrscan.R;

public class QRscan_th extends Fragment {
	
	TextView formatResultTxt3;
	TextView valResultTxt3;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_qrscan_th , container, false);

		return rootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		int prog = ClueManager.getProgress();
		if (prog ==4){
			TextView mTag3NotFound = (TextView) getView().findViewById(R.id.tag_3_notfound_marker);
			mTag3NotFound.setVisibility(TextView.GONE);
			ImageView mTag3Found = (ImageView) getView().findViewById(R.id.tag_3_found_marker);
			mTag3Found.setVisibility(View.VISIBLE);
			ImageView mTag3NextFound = (ImageView) getView().findViewById(R.id.tag_3_next);
			mTag3NextFound.setVisibility(View.VISIBLE);
		}
		
	}
	public void setText(String scanContent, String scanType) {
//	     formatResultTxt3 = (TextView) getView().findViewById(R.id.textType3);
	     valResultTxt3  = (TextView) getView().findViewById(R.id.textResult3);

	     formatResultTxt3.setText(scanType);
	     valResultTxt3.setText(scanContent);
	     
	}
	

}
