package com.stewhouse.tweety;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by 160229i-a on 16. 3. 21..
 */
public class TSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                finish();
            }
        };
        handler.postDelayed(runnable, TConstants.SPLASH_TIME);
    }

    @Override
    public void onBackPressed() {

        // Disable back button.
    }
}
