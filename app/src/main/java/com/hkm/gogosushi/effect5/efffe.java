package com.hkm.gogosushi.effect5;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hkm.gogosushi.R;

import java.util.ArrayList;


/**
 * Created by hesk on 4/12/2015.
 */
public class efffe extends Fragment {

    static final int ITEMS = 10;
    ViewPager mViewPager;
    static ArrayList<String> CHESSES = new ArrayList<String>();
    MyAdapter myAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CHESSES.add("Chesse0");
        final View view = inflater.inflate(R.layout.car_efff, null);
        myAdapter = new MyAdapter(getFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mViewPager.setAdapter(myAdapter);
        return view;
    }

    public void MyOnClick(View view) {
        int id = view.getId();
        int position;

        switch (id) {
            case R.id.goto_previous:
                position = mViewPager.getCurrentItem();
                CHESSES.add("Chesse" + (position + 1));
                if (position > 0) {
                    mViewPager.setCurrentItem(position - 1);
                } else {
                    Toast.makeText(getActivity(), "This is First Fragment", Toast.LENGTH_LONG).show();
                }
                myAdapter.notifyDataSetChanged();
                break;

            case R.id.goto_next:
                position = mViewPager.getCurrentItem();
                CHESSES.add("Chesse" + (position + 1));
                if (position < (ITEMS - 1)) {
                    mViewPager.setCurrentItem(position + 1);
                } else {
                    Toast.makeText(getActivity(), "This is Last Fragment", Toast.LENGTH_LONG).show();
                }
                myAdapter.notifyDataSetChanged();
                break;
        }
    }

    static class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(getClass().getSimpleName(), position + "");
            return ArrayListFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return ITEMS;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

}