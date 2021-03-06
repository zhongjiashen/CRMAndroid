package com.wtcrmandroid.activity.aboutdocument.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wtcrmandroid.model.reponsedata.DocumentListRpData;
import com.wtcrmandroid.model.requestdata.MyhaveDealRqData;
import com.wtcrmandroid.presenter.BasePresenter;
import com.wtcrmandroid.view.AllView;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zxd on 2017/7/5.
 */

public class MyhavedealPresenter extends BasePresenter {


    public MyhavedealPresenter(AllView view, Context context) {
        super(view, context);
    }

    @Override
    protected void returnData(int key, String response) {

        Type type = new TypeToken<List<DocumentListRpData>>() {
        }.getType();

        DocumentListRpData responseData = new Gson().fromJson(response, type);
        view.returnData(key,responseData);
    }

    /**
     * 我已审批fragment 数据请求
     *
     */

    public void postMydeal(MyhaveDealRqData dealRqData){

        post("Application/listApproved",dealRqData,0);
    }
}
