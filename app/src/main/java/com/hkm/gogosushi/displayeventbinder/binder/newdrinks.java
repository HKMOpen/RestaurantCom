package com.hkm.gogosushi.displayeventbinder.binder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkm.gogosushi.R;
import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBindAdapter;
import com.yqritc.recyclerviewmultipleviewtypesadapter.DataBinder;

/**
 * Created by hesk on 4/11/2015.
 */
public class newdrinks extends DataBinder<newdrinks.ViewHolder> {

    public newdrinks(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.event_lunch_promotion, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        Picasso.with(holder.mImageView.getContext())
                .load(R.drawable.controllerconsole128)
                .into(holder.mImageView);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleText;
        ImageView mImageView;
        TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mTitleText = (TextView) view.findViewById(R.id.title_type3);
            mImageView = (ImageView) view.findViewById(R.id.image_type3);
            mContent = (TextView) view.findViewById(R.id.content_type3);
        }
    }

}
