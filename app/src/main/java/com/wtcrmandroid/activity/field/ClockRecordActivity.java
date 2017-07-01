package com.wtcrmandroid.activity.field;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wtcrmandroid.BaseActivity;
import com.wtcrmandroid.MyApplication;
import com.wtcrmandroid.R;
import com.wtcrmandroid.adapter.recycleview.ClockRecordAdapter;
import com.wtcrmandroid.model.requestdata.ListPersonSignInRequestData;
import com.wtcrmandroid.presenter.activity.ClockRecordPresenter;
import com.wtcrmandroid.view.RefreshHeaderView;
import com.wtcrmandroid.view.RefreshLoadMoreFooterView;
import com.wtcrmandroid.view.custompricing.TitleBar;
import com.wtcrmandroid.view.pulltorefresh.OnLoadMoreListener;
import com.wtcrmandroid.view.pulltorefresh.OnRefreshListener;
import com.wtcrmandroid.view.pulltorefresh.SwipeToLoadLayout;

import butterknife.BindView;

/**
 * Created by wt-pc on 2017/6/17.
 * 打卡记录
 */

public class ClockRecordActivity extends BaseActivity<ClockRecordPresenter, Object> implements OnLoadMoreListener, OnRefreshListener {
    @BindView(R.id.titlebar)
    TitleBar titlebar;
    @BindView(R.id.swipe_target)
    RecyclerView rvView;

    @BindView(R.id.swipe_refresh_header)
    RefreshHeaderView mHeaderView;
    @BindView(R.id.swipe_load_more_footer)
    RefreshLoadMoreFooterView mFooterView;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout mSwipeToLoadLayout;
    private ClockRecordAdapter adapter;
    private int page = 1;//当前页码
    ListPersonSignInRequestData data;

    @Override
    public void returnData(int key, Object data) {

    }

    @Override
    protected int layout() {
        return R.layout.activity_clock_record;
    }

    @Override
    protected void initView() {
        titlebar.setTitletext("打卡记录");
        titlebar.setLeftOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rvView.setLayoutManager(new LinearLayoutManager(this));
        rvView.setAdapter(adapter = new ClockRecordAdapter(this));
        presenter = new ClockRecordPresenter(this);
        data = new ListPersonSignInRequestData();

        data.setUserId(MyApplication.application.getLoginData().getUserID());
        data.setPageSize(1);
        presenter.sedPost(data,0);
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
