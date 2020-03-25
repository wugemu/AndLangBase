package com.lang.andlang2;

import android.databinding.DataBindingUtil;

import com.example.test.andlang.andlangutil.BaseLangActivity;
import com.example.test.andlang.util.ToastUtil;
import com.lang.andlang2.model.api.MainBean;
import com.lang.andlang2.persenter.MainPersenter;
import com.lang.andlang2.util.Constants;

import butterknife.OnClick;

public class MainActivity extends BaseLangActivity<MainPersenter> {
    private MainBean mainBean;
    @Override
    public void notifyView(String tag) {
        if(Constants.GET_VERSION.equals(tag)){
            ToastUtil.show(MainActivity.this,"请求结果返回");
        }
    }

    @Override
    public void dataBindingView() {
        MainBinding mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main_test);
        mainBean=new MainBean();
        mainBean.setTitle("测试测试11111");
        mainBinding.setMybean(mainBean);
    }

    @Override
    public void initView() {

        initLoading();
        initTitleBar(false,"新架构");
    }

    @Override
    public void initPresenter() {
        presenter=new MainPersenter(MainActivity.this);
    }

    @Override
    public void initData() {
        showWaitDialog();
        presenter.reqVersion();
    }

    @OnClick(R.id.btn_change)
    public void clickChangeBtn(){
        //修改
        mainBean.setTitle("点击修改按钮");
    }

}
