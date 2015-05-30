package com.hkm.gogosushi.modules;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkm.gogosushi.R;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hesk on 5/31/2015.
 */
public class MultiSwapBinder extends DataBinder<MultiSwapBinder.ViewHolder> {
    List<String> dataSet;
    final Picasso pica;
    final Context cc;

    public MultiSwapBinder(MultiViewTypesRecyclerViewAdapter dataBindAdapter, List<String> dataSet) {
        super(dataBindAdapter);
        this.dataSet = dataSet;
        cc = dataBindAdapter.getContext();
        pica = Picasso.with(cc);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.m_promotion_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        try {
            String title = cc.getResources().getString(R.string.sample_title);
            String url = cc.getResources().getString(R.string.sample_coupon_url);
            holder.mTitleText.setText(title);
            pica.load(url).into(holder.mImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder extends MultiViewTypesRecyclerViewAdapter.UltimateRecyclerviewViewHolder {

        TextView mTitleText;
        ImageView mImageView;
        TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mTitleText = (TextView) view.findViewById(R.id.title_type1);
            mImageView = (ImageView) view.findViewById(R.id.image_type1);
            mContent = (TextView) view.findViewById(R.id.content_type1);
        }
    }
}
