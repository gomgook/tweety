package com.stewhouse.tweety;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

public class TMainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList = null;
    private FrameLayout mContentFrame = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(TMainActivity.this, TSplashActivity.class);
        startActivity(intent);

        setContentView(R.layout.activity_main);

        initDrawer();

        mDrawerList.performItemClick(null, 0, 0);
    }

    private void initDrawer() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        View childView = decorView.getChildAt(0);
        mDrawerLayout = (DrawerLayout) inflater.inflate(R.layout.drawer_layout, null);
        mContentFrame = (FrameLayout) mDrawerLayout.findViewById(R.id.content_frame);
        mDrawerList = (ListView) mDrawerLayout.findViewById(R.id.drawer_list);

        if (mContentFrame != null) {
            decorView.removeView(childView);
            mContentFrame.addView(childView);
            decorView.addView(mDrawerLayout);
        }

        if (mDrawerLayout != null) {
            TDrawerListAdapter drawerListAdapter = new TDrawerListAdapter(this);
            mDrawerList.setAdapter(drawerListAdapter);
            mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {    // Profile Cell.
                        Fragment fragment = new TTimelineFragment();
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                        mDrawerList.setItemChecked(position, true);
                        mDrawerLayout.closeDrawer(mDrawerList);
                    }
                }
            });
        }
    }
}
