package com.wtcrmandroid.adapter.recycleview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.thinkcool.circletextimageview.CircleTextImageView;
import com.wtcrmandroid.R;
import com.wtcrmandroid.activity.field.StatisticsDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wt-pc on 2017/6/19.
 * 外勤统计
 */

public class FieldStatisticaAdapter extends BaseRecycleAdapter<String,FieldStatisticaAdapter.ViewHolder> {
    /**
     * @param context  //上下文
     */
    public FieldStatisticaAdapter(Context context) {
        super(context, R.layout.item_field);
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }


    @Override
    protected void convert(ViewHolder holder, String bean,int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,StatisticsDetailsActivity.class));
            }
        });

    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ctiv_photo)
        CircleTextImageView ctivPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

       
    }
}
