package com.stewhouse.tweety;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Gomguk on 16. 4. 8..
 */
public class TApplication extends Application {
    private boolean isAuthorized = false;

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TConstants.TWITTER_KEY, TConstants.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public static void setAuthorization(Activity activity) {
        Intent intent = new Intent(activity, TAuthorizeActivity.class);
        activity.startActivity(intent);
    }
}
