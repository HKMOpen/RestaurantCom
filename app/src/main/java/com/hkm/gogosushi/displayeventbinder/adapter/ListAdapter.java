package com.hkm.gogosushi.displayeventbinder.adapter;

/**
 * Created by hesk on 4/11/2015.
 */

import com.hkm.gogosushi.displayeventbinder.binder.alicar;
import com.hkm.gogosushi.displayeventbinder.binder.newdish;
import com.hkm.gogosushi.displayeventbinder.binder.newdrinks;
import com.hkm.gogosushi.displayeventbinder.data.EventsJSON;
import com.yqritc.recyclerviewmultipleviewtypesadapter.ListBindAdapter;

import java.util.List;

public class ListAdapter extends ListBindAdapter {

    public ListAdapter() {
        addAllBinder(
                new alicar(this),
                new newdish(this),
                new newdrinks(this));
    }

    public void setSample2Data(List<EventsJSON> dataSet) {
        ((newdish) getDataBinder(1)).addAll(dataSet);
    }
}