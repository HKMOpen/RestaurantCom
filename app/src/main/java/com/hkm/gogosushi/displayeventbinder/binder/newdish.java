package com.hkm.gogosushi.displayeventbinder.binder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkm.gogosushi.R;
import com.hkm.gogosushi.displayeventbinder.data.EventsJSON;
import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hesk on 4/11/2015.
 */
public class newdish extends DataBinder<newdish.ViewHolder> {

    private List<EventsJSON> mDataSet = new ArrayList<>();

    public newdish(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.event_special, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        EventsJSON data = mDataSet.get(position);
        holder.mTitleText.setText(data.mTitle);
        holder.mContent.setText(data.mContent);
        if (data.mDrawableResId > 0)
            Picasso.with(holder.mImageView.getContext())
                    .load(data.mDrawableResId)
                    .into(holder.mImageView);
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void addAll(List<EventsJSON> dataSet) {
        mDataSet.addAll(dataSet);
        notifyBinderDataSetChanged();
    }

    public void clear() {
        mDataSet.clear();
        notifyBinderDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleText;
        ImageView mImageView;
        TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mTitleText = (TextView) view.findViewById(R.id.title_type2);
            mImageView = (ImageView) view.findViewById(R.id.image_type2);
            mContent = (TextView) view.findViewById(R.id.content_type2);
        }
    }

}
