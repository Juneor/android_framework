package com.android.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
  public static boolean isConnectWifi(Context paramContext) {
    int i = 1;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == i)){
    	return true;
    }
    return false;
  }
  
  public static boolean isConnectMobile(Context paramContext) {
	  if(!isConnectWifi(paramContext) && isNetworkAvailable(paramContext)){
		  return true;
	  } 
      return false;
  }

  public static boolean isNetworkAvailable(Context paramContext) {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())){
    	return true;
    }
    return false;
  }
}