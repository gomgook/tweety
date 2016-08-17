package com.stewhouse.tweety;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by Gomguk on 16. 4. 12..
 */
public class TAuthorizeActivity extends AppCompatActivity {

    // TODO: test code.
    private TwitterLoginButton loginButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authorize);

        // TODO: test code.
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {

            @Override
            public void success(Result<TwitterSession> result) {

                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                // with your app's user model
                authorizeTwitter();
                finish();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.twitter_login_error), Toast.LENGTH_LONG).show();
                Log.e("TwitterKit", "Login with Twitter failure", exception);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {

        // Send application to background when the back key is pressed.
        moveTaskToBack(true);
    }

    private void authorizeTwitter() {
        TApplication application = (TApplication) getApplication();
        if (application != null) {
            application.setIsAuthorized(true);
        }
    }
}