package com.stewhouse.tweety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ListView;

import com.stewhouse.tweety.utility.TAppCompatActivity;

public class TMainActivity extends TAppCompatActivity {
    private ListView mDrawerList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use TAppCompatActivity's content_viewstub to show TAppCompatActivity's content.
        ViewStub viewStub = (ViewStub) findViewById(R.id.content_viewstub);
        viewStub.setLayoutResource(R.layout.activity_main);
        viewStub.inflate();

        TApplication application = (TApplication) getApplication();
        if (application.isAuthorized() == true) {
            initDrawer();
        } else {
            TApplication.setAuthorization(this);
        }
    }

    private void initDrawer() {
        mDrawerList = (ListView) findViewById(R.id.list_drawer);
        if (mDrawerList != null) {
            mDrawerList.setAdapter(new TDrawerListAdapter(this));
            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position == 0) {    // Profile Cell.
                        Intent intent = new Intent(TMainActivity.this, TProfileActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
