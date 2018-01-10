package com.stewhouse.tweety;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Gomguk on 16. 4. 8..
 */
public class TApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Fabric Twitter SDK.
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TConstants.TWITTER_KEY,
                TConstants.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }
}
