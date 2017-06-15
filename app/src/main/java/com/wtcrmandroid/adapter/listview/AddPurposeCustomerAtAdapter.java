package com.wtcrmandroid.adapter.listview;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wtcrmandroid.R;
import com.wtcrmandroid.model.AddPurpostCtAtData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxd on 2017/6/14
 */

public class AddPurposeCustomerAtAdapter extends MySmallBaseAdapter<AddPurpostCtAtData, AddPurposeCustomerAtAdapter.ViewHolder> {

    public AddPurposeCustomerAtAdapter(Activity activity, List<AddPurpostCtAtData> list) {
        super(activity, list);
    }

    @Override
    protected void convert(ViewHolder holder, int position) {

        AddPurpostCtAtData addPurpostCtAtData = list.get(position);
        holder.mTvMajorSort.setText(addPurpostCtAtData.getWorkSort());
        holder.mEtMajorName.setText(addPurpostCtAtData.getCustomerName());
        holder.mEtMajorAnalysis.setText(addPurpostCtAtData.getAnalysisGjin());

        holder.mEtMajorName.addTextChangedListener(new MyTextWatcher(addPurpostCtAtData,
                position,0));
        holder.mEtMajorAnalysis.addTextChangedListener(new MyTextWatcher(addPurpostCtAtData,
                position,1));

        //事项的等级
        holder.mRlMajorSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected View onCreateViewHolder() {

        View view = LayoutInflater.from(activity).inflate(R.layout.item_add_ppcustomer, null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.tv_major_sort)
        TextView mTvMajorSort;
        @BindView(R.id.iv_delete)
        ImageView mIvDelete;
        @BindView(R.id.rl_major_sort)
        RelativeLayout mRlMajorSort;
        @BindView(R.id.et_major_name)
        EditText mEtMajorName;
        @BindView(R.id.et_major_analysis)
        EditText mEtMajorAnalysis;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class MyTextWatcher implements TextWatcher{

        private AddPurpostCtAtData mData;
        private int position;
        private int type;

        public MyTextWatcher(AddPurpostCtAtData data, int position, int type) {
            mData = data;
            this.position = position;
            this.type = type;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            switch (type){
                case 0:
                    mData.setCustomerName(s.toString());
                    break;
                case 1:
                    mData.setAnalysisGjin(s.toString());
                    break;
                default:
                    break;
            }
            list.set(position,mData);
        }
    }
}
