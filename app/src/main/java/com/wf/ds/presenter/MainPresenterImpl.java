package com.wf.ds.presenter;

import com.wf.ds.base.BasePresenter;
import com.wf.ds.contract.MainContract;
import com.wf.ds.model.MainModelImpl;
import com.wf.ds.model.UserBean;
import com.wf.ds.utils.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter{

    private MainContract.IMainModel mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainModel = new MainModelImpl(this);

    }
    @Override
    public void login(String name,String password) {

//        URL就在P层确定,不要从Activity中传递过来
        mainModel.getLoginData("", new INetCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                iView.getData(userBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
