package com.orlando.qrscan.activity;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.preference.PreferenceManager;
import android.util.Log;

import com.orlando.qrscan.R;
import com.orlando.qrscan.R.string;

public class ClueManager {
	public static String ME="com.orlando.qrscan.activity.ClueManager";
	public static String clues[] ;
	public static ArrayList<String> cluesList = new ArrayList<String>();
	public static Context cont=null;
	public static String clue =null;
	public static String[] cluesTA = null;

	public static void initClueManager(Context con){

		
		ClueManager.setCont(con);
		cluesTA = con.getResources().getStringArray(R.array.clues);

		
		
	}
	
	public static int getProgress(){
		SharedPreferences appSharedPrefs = PreferenceManager
	      		  .getDefaultSharedPreferences(getCont());
		int progress = appSharedPrefs.getInt("prog", 1);
		
		return progress;
	}
	public static boolean setProgress(String found){
		SharedPreferences appSharedPrefs = PreferenceManager
	      		  .getDefaultSharedPreferences(getCont());
			
		
			int progress = appSharedPrefs.getInt("prog", 1);
			
			
			clue= cluesTA[progress];

			if (clue.equalsIgnoreCase(found)){
//			if (cluesList.get(progress).equalsIgnoreCase(found)){
				Editor prefsEditor = appSharedPrefs.edit();			
				prefsEditor.putInt("prog", progress+1);
		        prefsEditor.commit();
		        Log.i(ME, "clue found!");
		        return true;
			}
			else{
				Log.w(ME, "wrong clue progress!");
				return false;
			}
	}
	
	
	
	
	public static Context getCont() {
		return ClueManager.cont;
	}

	public static void setCont(Context cont) {
		ClueManager.cont = cont;
	}
}
