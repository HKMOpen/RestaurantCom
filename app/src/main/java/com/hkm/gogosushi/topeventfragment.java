package com.hkm.gogosushi;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hkm.gogosushi.displayeventbinder.adapter.EnumMapAdapter;
import com.hkm.gogosushi.displayeventbinder.data.EventsJSON;
import com.hkm.longmenu.Bind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesk on 4/11/2015.
 */
public class topeventfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("Right", "onCreateView()");
        return inflater.inflate(R.layout.listevents, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("TAG", "onViewCreated");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_main);
        LinearLayout mcontainerholder = (LinearLayout) view.findViewById(R.id.containerholder);
        //final BlurringView mBlurringView = (BlurringView) view.findViewById(R.id.blurvi);
        EnumMapAdapter adapter = new EnumMapAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setSample2Data(getSampleData());
        mcontainerholder.setBackgroundResource(Bind.Pattern.DEFAULTBLACK);
       /*
       recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                mBlurringView.invalidate();
            }
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
            }
        });
        mBlurringView.setBlurredView(recyclerView);
        */
    }

    private List<EventsJSON> getSampleData() {
        List<EventsJSON> dataSet = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            EventsJSON data = new EventsJSON();
            data.mTitle = "View Type 2";
            data.mDrawableResId = getResources().getIdentifier("animal" + i, "drawable", getActivity().getPackageName());
            data.mContent = "This is sample data for view type 2 - " + i;
            dataSet.add(data);
        }
        return dataSet;
    }
}
