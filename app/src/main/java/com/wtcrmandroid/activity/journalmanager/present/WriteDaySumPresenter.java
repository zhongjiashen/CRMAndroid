package com.wtcrmandroid.activity.journalmanager.present;

import com.google.gson.Gson;
import com.wtcrmandroid.MyApplication;
import com.wtcrmandroid.model.reponsedata.WjournalData;
import com.wtcrmandroid.presenter.BasePresenter;
import com.wtcrmandroid.utils.L;
import com.wtcrmandroid.view.AllView;

/**
 * Created by ZSC on 2017/6/30.
 */

public class WriteDaySumPresenter extends BasePresenter {

    public WriteDaySumPresenter(AllView view) {
        super(view);
    }

    @Override
    protected void returnData(int key, String response) {

        WjournalData wjournalData = new Gson().fromJson(response, WjournalData.class);
        L.e("成功" + wjournalData.toString());
        view.returnData(key, wjournalData);

    }

    /**
     * 提交后台日总结
     */

    public void SubDaySum(Object o){
        post("WorkPlan/saveWorkPlan",o,0);
    }
}