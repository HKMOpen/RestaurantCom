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
public class eventcountdown extends DataBinder<eventcountdown.ViewHolder> {

    public eventcountdown(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.event_layout_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(R.drawable.icoshlogo);
        Picasso.with(holder.mImageView.getContext())
                .load(R.drawable.abc_btn_check_to_on_mtrl_015)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

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
