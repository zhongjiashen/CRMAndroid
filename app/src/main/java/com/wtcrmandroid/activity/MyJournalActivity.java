package com.wtcrmandroid.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.wtcrmandroid.R;
import com.wtcrmandroid.adapter.MyJournalAdapter;
import com.wtcrmandroid.custompricing.TitleBar;
import com.wtcrmandroid.http.retrofit2.data.BaseData;
import com.wtcrmandroid.model.MyJournalData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的日志Activity
 * @author zxd
 * @date 2017/6/6
 */

public class MyJournalActivity extends BaseActivity {

    @BindView(R.id.titlebar)
    TitleBar mTitlebar;
    @BindView(R.id.ll_myjournal_type)
    LinearLayout mLlMyjournalType;  //类型筛选按钮
    @BindView(R.id.ll_myjournal_time)
    LinearLayout mLlMyjournalTime;  //时间筛选按钮
    @BindView(R.id.lv_myjournal)
    ListView mLvMyjournal;          //我的日志列表
    @BindView(R.id.ll_xiala_type)
    LinearLayout mLlXialaType;      //类型弹框
    @BindView(R.id.iv_type_arrow)
    ImageView mIvTypeArrow;         //类型向下箭头
    @BindView(R.id.iv_time_arrow)
    ImageView mIvTimeArrow;         //时间向下箭头
    private MyJournalAdapter mAdapter;
    private List<MyJournalData>mList;

    @Override
    protected int layout() {
        return R.layout.activity_my_journal;
    }

    @Override
    protected void initview() {
        mList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            MyJournalData myJournalData = new MyJournalData();
            myJournalData.setJournalContent("这个，那个，啥");
            myJournalData.setJournalTitle("2017-5-31日计划");
            mList.add(myJournalData);
        }
        mTitlebar.setTitletext("我的日志");
        mAdapter = new MyJournalAdapter(mList);
        mLvMyjournal.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mLvMyjournal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    startActivity(new Intent(MyJournalActivity.this,HtDaysumDetailsActivity.class));
                }else {
                    startActivity(new Intent(MyJournalActivity.this,HtDayplanDetails.class));
                }
            }
        });
    }

    @Override
    public void returnData(int key, BaseData data) {

    }


    @OnClick(R.id.ll_myjournal_type)
    public void onViewClicked() {

        if (mLlXialaType.getVisibility() == View.VISIBLE) {
            mLlXialaType.setVisibility(View.INVISIBLE);
            ObjectAnimator anim = ObjectAnimator.ofFloat(mIvTypeArrow, "rotation", 180f, 0f);
            anim.setDuration(200);
            anim.start();
        } else {
            mLlXialaType.setVisibility(View.VISIBLE);
            ObjectAnimator anim = ObjectAnimator.ofFloat(mIvTypeArrow, "rotation", 0f, 180f);
            anim.setDuration(200);
            anim.start();
        }

    }

}
