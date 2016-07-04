package com.stewhouse.tweety;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewStub;

/**
 * Created by Gomguk on 16. 3. 30..
 */
public class TProfileActivity extends TAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use TAppCompatActivity's content_viewstub to show TAppCompatActivity's content.
        ViewStub viewStub = (ViewStub) findViewById(R.id.content_viewstub);
        viewStub.setLayoutResource(R.layout.activity_profile);
        viewStub.inflate();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
