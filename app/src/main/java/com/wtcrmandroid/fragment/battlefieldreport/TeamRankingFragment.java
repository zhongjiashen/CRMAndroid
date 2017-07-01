package com.wtcrmandroid.fragment.battlefieldreport;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wtcrmandroid.BaseFragment;
import com.wtcrmandroid.R;
import com.wtcrmandroid.adapter.recycleview.TeamRankingAdapter;

import butterknife.BindView;

/**
 * Created by wt-pc on 2017/6/20.
 * 销售战报团队排名
 */

public class TeamRankingFragment extends BaseFragment {
    @BindView(R.id.rv_view)
    RecyclerView rvView;
    TeamRankingAdapter adapter;
    @Override
    public void returnData(int key, Object data) {

    }

    @Override
    protected int Rlayout() {
        return R.layout.fragment_team_ranking;
    }

    @Override
    protected void init() {
        rvView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvView.setAdapter(adapter=new TeamRankingAdapter(getActivity()));
    }


}
