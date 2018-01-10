package com.stewhouse.tweety.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.stewhouse.tweety.TAuthorizeActivity;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;

/**
 * Created by Gomguk on 2018. 1. 9..
 */

public class BaseAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        checkTwitterAuthorization();
    }

    public void checkTwitterAuthorization() {
        TwitterSession session = Twitter.getSessionManager().getActiveSession();

        if (session == null) {  // 인증 token이 만료되었을 경우.
            splashAuthorization();
        }
    }

    public void splashAuthorization() {
        Intent intent = new Intent(this, TAuthorizeActivity.class);

        startActivity(intent);
    }
}
