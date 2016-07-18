package com.stewhouse.tweety.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.stewhouse.tweety.R;
import com.stewhouse.tweety.TApplication;

/**
 * Created by Gomguk on 16. 7. 4..
 */
public class TAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_appcompat);

        // Setting ToolBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!TApplication.isAuthorized()) {
            TApplication.splashAuthorization(this);
        }
    }
}
