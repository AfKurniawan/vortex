package com.creativedna.vortex.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class Util {

    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info == null)
            return false;
        else
            return info.isConnected();
    }
}
