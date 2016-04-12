package com.stewhouse.tweety;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TMainActivity extends AppCompatActivity {
    private ListView mDrawerList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Setting ToolBar in the DrawerLayout.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
