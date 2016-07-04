package com.stewhouse.tweety;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewStub;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by Gomguk on 16. 4. 12..
 */
public class TAuthorizeActivity extends TAppCompatActivity {

    // TODO: test code.
    private TwitterLoginButton loginButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use TAppCompatActivity's content_viewstub to show TAppCompatActivity's content.
        ViewStub viewStub = (ViewStub) findViewById(R.id.content_viewstub);
        viewStub.setLayoutResource(R.layout.activity_authorize);
        viewStub.inflate();

        // TODO: test code.
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {

            @Override
            public void success(Result<TwitterSession> result) {

                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;

                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // TODO: test code.
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {

        // Send application to background when the back key is pressed.
        moveTaskToBack(true);
    }
}
