package com.creativedna.vortex;

import android.app.Application;

import com.creativedna.vortex.helpers.SharedPreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Bryan Lamtoo - creativeDNA (U) LTD.
 */
public class AppDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        instantiateManagers();
    }


    /**
     * Method to instantiate all the managers in this app
    */
    private void instantiateManagers() {
        FacebookSdk.sdkInitialize(this);
        AppEventsLogger.activateApp(this);
        Fresco.initialize(this);
        SharedPreferenceManager.getSharedInstance().initiateSharedPreferences(getApplicationContext());
//        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
//        Fabric.with(this, new Twitter(authConfig));
    }


}
