package com.android.common.data.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ISharedPreference {
	
	private Context mContext;
	private final String PREF_NAME = "shared_pref_data";
	private final static String FIRST_LOGIN_FLAG = "first_login_flag";
    private SharedPreferences sharedPref;
    private static ISharedPreference iSharedPref;
    private static Editor editor;
	private ISharedPreference(Context mContext) {
		super();
		this.mContext = mContext;
		sharedPref = this.mContext.getSharedPreferences(PREF_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
		editor = sharedPref.edit();
	}
	
	public static ISharedPreference getInstance(Context mContext){
		if(iSharedPref == null){
			
			iSharedPref = new ISharedPreference(mContext);
		}
		
		return iSharedPref;
	}

	public  void setFirstLoginFlag(boolean firstLogin){
		editor.putBoolean(FIRST_LOGIN_FLAG,firstLogin);
		editor.commit();
	}
	
	public boolean getFirstLoginFlag(){
		return sharedPref.getBoolean(FIRST_LOGIN_FLAG, true);
	}
}
