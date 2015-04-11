package com.hkm.gogosushi.displayeventbinder.adapter;

/**
 * Created by hesk on 4/11/2015.
 */

import com.hkm.gogosushi.displayeventbinder.binder.alicar;
import com.hkm.gogosushi.displayeventbinder.binder.eventcountdown;
import com.hkm.gogosushi.displayeventbinder.binder.newdish;
import com.hkm.gogosushi.displayeventbinder.binder.newdrinks;
import com.hkm.gogosushi.displayeventbinder.data.EventsJSON;
import com.yqritc.recyclerviewmultipleviewtypesadapter.EnumMapBindAdapter;

import java.util.List;

/**
 * Created by yqritc on 2015/03/20.
 */
public class EnumMapAdapter extends EnumMapBindAdapter<EnumMapAdapter.displayType> {

    enum displayType {
        ALLYOUCANEAT, NEWDISH, NEWDRINKS, SPECIALPARTYEVENT
    }

    public EnumMapAdapter() {
        putBinder(displayType.ALLYOUCANEAT, new alicar(this));
        putBinder(displayType.NEWDISH, new newdish(this));
        putBinder(displayType.NEWDRINKS, new newdrinks(this));
        putBinder(displayType.SPECIALPARTYEVENT, new eventcountdown(this));
    }

    public void setSample2Data(List<EventsJSON> dataSet) {
        ((newdish) getDataBinder(displayType.NEWDISH)).addAll(dataSet);
    }

    @Override
    public displayType getEnumFromPosition(int position) {
        if (position == 1) {
            return displayType.ALLYOUCANEAT;
        } else if (position == 3) {
            return displayType.NEWDISH;
        } else {
            return displayType.NEWDRINKS;
        }
    }

    @Override
    public displayType getEnumFromOrdinal(int ordinal) {
        return displayType.values()[ordinal];
    }
}
