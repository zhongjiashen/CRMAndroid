package com.wtcrmandroid.fragment.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.wtcrmandroid.R;
import com.wtcrmandroid.activity.JournalManagerActivity;
import com.wtcrmandroid.activity.MainActivity;
import com.wtcrmandroid.activity.field.FieldActivity;
import com.wtcrmandroid.custompricing.TitleBar;
import com.wtcrmandroid.fragment.BaseFragmengt;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

/**
 * Created by 1363655717 on 2017-06-01.
 */

public class HomeFragment extends BaseFragmengt {
    @BindView(R.id.titlebar)
    TitleBar titlebar;


    private boolean window;
    private PopupWindow mPopWindow;

    @Override
    protected int Rlayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        titlebar.serLeftImageVisibility(GONE);
        titlebar.setLeftText("工作台");
        titlebar.setRightImageResource(R.mipmap.ico_plus);
        titlebar.setRightOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                if (window) {

                    RotateAnimation operatingAnim = (RotateAnimation) AnimationUtils.loadAnimation(
                            getActivity(), R.anim.rotating_45);
                    LinearInterpolator lin = new LinearInterpolator();
                    operatingAnim.setInterpolator(lin);
                    titlebar.getRightImage().startAnimation(operatingAnim);
                    window = false;
//                    activity.setTitleWindow(GONE);
                    mPopWindow.dismiss();
                } else {


                    RotateAnimation operatingAnim = (RotateAnimation) AnimationUtils.loadAnimation(
                            getActivity(), R.anim.rotating45);
                    LinearInterpolator lin = new LinearInterpolator();
                    operatingAnim.setInterpolator(lin);
                    titlebar.getRightImage().startAnimation(operatingAnim);
//                    activity.setTitleWindow(View.VISIBLE);
                    window = true;
                    showPopupWindow();
                }
            }
        });


    }


    @Override
    public void returnData(int key, Object data) {

    }

    @OnClick({R.id.tv_log_management, R.id.tv_field})
    public void onClick(View view) {
        switch (view.getId()) {
            //日志管理点击事件
            case R.id.tv_log_management:
                startActivity(new Intent(getActivity(), JournalManagerActivity.class));
                break;
            //外勤点击事件
            case R.id.tv_field:
                startActivity(new Intent(getActivity(), FieldActivity.class));
                break;
        }
    }

    private void showPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.popupwindow_home, null);
        ViewHolder holder= new ViewHolder(contentView);
        holder.llControlFragmentOrderMetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dasfasd", Toast.LENGTH_SHORT).show();
            }
        });
        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);
        mPopWindow.setFocusable(false); // 设置PopupWindow可获得焦点
        //设置各个控件的点击响应
        mPopWindow.showAsDropDown(titlebar);

    }

    static class ViewHolder {
        @BindView(R.id.ll_control_fragment_write_journal)
        LinearLayout llControlFragmentWriteJournal;
        @BindView(R.id.ll_control_fragment_send_approval)
        LinearLayout llControlFragmentSendApproval;
        @BindView(R.id.ll_control_fragment_send_notice)
        LinearLayout llControlFragmentSendNotice;
        @BindView(R.id.ll_control_fragment_write_customer)
        LinearLayout llControlFragmentWriteCustomer;
        @BindView(R.id.ll_control_fragment_order_metting)
        LinearLayout llControlFragmentOrderMetting;
        @BindView(R.id.ll_control_fragment_product_advice)
        LinearLayout llControlFragmentProductAdvice;
        @BindView(R.id.cancle_onlick)
        LinearLayout cancleOnlick;
        @BindView(R.id.title_window)
        LinearLayout titleWindow;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
