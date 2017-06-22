package com.wtcrmandroid.activity.field;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wtcrmandroid.R;
import com.wtcrmandroid.activity.BaseActivity;
import com.wtcrmandroid.adapter.recycleview.BaseRecycleAdapter;
import com.wtcrmandroid.adapter.recycleview.FieldStatisticaAdapter;
import com.wtcrmandroid.custompricing.TitleBar;
import com.wtcrmandroid.custompricing.TopChooseMenuBar;

import butterknife.BindView;

/**
 * Created by 1363655717 on 2017-06-14.
 * 外勤统计
 */

public class FieldStatisticsAcrivity extends BaseActivity {
    @BindView(R.id.titlebar)
    TitleBar titlebar;
    @BindView(R.id.tcmb_bar)
    TopChooseMenuBar tcmbBar;
    @BindView(R.id.rv_view)
    RecyclerView rvView;

    private BaseRecycleAdapter adapter;

    @Override
    public void returnData(int key, Object data) {

    }

    @Override
    protected int layout() {
        return R.layout.activity_field_statistics;
    }

    @Override
    protected void initview() {
        titlebar.setTitletext("外勤统计");
        titlebar.setLeftOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tcmbBar.setOnCheckedChangedListener(new TopChooseMenuBar.OnCheckedChangedListener() {
            @Override
            public void isSelected(int i) {


            }

            @Override
            public void isNoSelected(int i) {


            }
        });
        rvView.setLayoutManager(new LinearLayoutManager(this));
        rvView.setAdapter(adapter=new FieldStatisticaAdapter(this));
    }



}
