package com.stewhouse.tweety;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Gomguk on 16. 3. 21..
 */
public class TDrawerListAdapter extends BaseAdapter {
    private Activity mActivity = null;

    public TDrawerListAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mActivity);

            // Profile View Cell Setting.
            if (position == 0) {
                convertView = layoutInflater.inflate(R.layout.cell_drawer_profile,
                        parent,
                        false);
            }
        }

        return convertView;
    }
}
