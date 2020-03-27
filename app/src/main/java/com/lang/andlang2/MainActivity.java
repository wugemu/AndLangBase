package com.lang.andlang2;

import android.databinding.DataBindingUtil;
import android.widget.TextView;

import com.example.test.andlang.andlangutil.BaseLangActivity;
import com.example.test.andlang.util.LogUtil;
import com.example.test.andlang.util.ToastUtil;
import com.lang.andlang2.model.api.MainBean;
import com.lang.andlang2.persenter.MainPersenter;
import com.lang.andlang2.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseLangActivity<MainPersenter,MainBinding> {
    @BindView(R.id.tv_text_value)
    TextView tv_text_value;
    private MainBean mainBean;
    @Override
    public void notifyView(String tag) {
        if(Constants.GET_VERSION.equals(tag)){
            ToastUtil.show(MainActivity.this,"请求结果返回");
        }
    }
    @Override
    public void dataBindingView() {
        viewDataBind=DataBindingUtil.setContentView(this,R.layout.activity_main_test);
        mainBean=new MainBean();
        mainBean.title.set("测试测试11111");
        viewDataBind.setMyBean(mainBean);
    }

    @Override
    public void initView() {

        initLoading();
        initTitleBar(false,"新架构");
    }

    @Override
    public void initPresenter() {
        presenter=new MainPersenter(MainActivity.this,viewDataBind);
    }

    @Override
    public void initData() {
        showWaitDialog();
        presenter.reqVersion();
    }

    @OnClick(R.id.btn_change)
    public void clickChangeBtn(){
        //修改
        viewDataBind.getMyBean().title.set("点击修改按钮");
        ToastUtil.show(MainActivity.this,mainBean.title.get());
    }

}
