package com.orlando.qrscan.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;




public class FragmentHandler {

	public static boolean addFragmentInBackStack(FragmentManager fragmentManager, String backStackName, String tag, Fragment fragment, int fragCointeinerResId){

		/**
		 *  ATTENZIONE: Quando si usa questo metodo per inserire il primo fragment nell'activity, la variabile "backStackName" deve essere passato null!!!
		 */
		if(fragmentManager.findFragmentByTag(tag) == null || (fragmentManager.findFragmentByTag(tag) != null && !fragmentManager.findFragmentByTag(tag).isVisible())){
			FragmentTransaction ft = null;
			ft = fragmentManager.beginTransaction();
			ft.replace(fragCointeinerResId, fragment, tag);
			if(backStackName != null)
				ft.addToBackStack(backStackName);
			ft.commit();
			return true;
		}
		return false;
	}
	
	public static boolean addFragment(FragmentManager fragmentManager, String tag, Fragment fragment, int fragCointeinerResId){

		/**
		 *  ATTENZIONE: Quando si usa questo metodo per inserire il primo fragment nell'activity, la variabile "backStackName" deve essere passato null!!!
		 */
		if(fragmentManager.findFragmentByTag(tag) == null || (fragmentManager.findFragmentByTag(tag) != null && !fragmentManager.findFragmentByTag(tag).isVisible())){
			FragmentTransaction ft = null;
			ft = fragmentManager.beginTransaction();
			ft.add(fragCointeinerResId, fragment, tag);
			ft.commit();
			return true;
		}
		return false;
	}
	
	public static boolean replaceFragment(FragmentManager fragmentManager, String tag, Fragment fragment, int fragCointeinerResId){

		/**
		 *  ATTENZIONE: Quando si usa questo metodo per inserire il primo fragment nell'activity, alla variabile "backStackName" deve essere passato null!!!
		 */
		if(fragmentManager.findFragmentByTag(tag) == null || (fragmentManager.findFragmentByTag(tag) != null && !fragmentManager.findFragmentByTag(tag).isVisible())){
			FragmentTransaction ft = null;
			ft = fragmentManager.beginTransaction();
			ft.replace(fragCointeinerResId, fragment, tag);
			ft.commit();
			return true;
		}
		return false;
	}

	public static void clearFragmentBackStack(FragmentManager fragmentManager, String backStackName){
		fragmentManager.popBackStack (backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
	}

}
