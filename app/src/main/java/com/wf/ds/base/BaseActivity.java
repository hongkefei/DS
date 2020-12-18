package com.wf.ds.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wf.ds.contract.MainContract;
import com.wf.ds.presenter.MainPresenterImpl;

public abstract class BaseActivity<P extends BasePresenter>  extends AppCompatActivity implements BaseView{

    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());

        if(presenter ==null){
            presenter  = add();
            presenter.attachView(this);
        }

        initView();
        initData();


    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutID();

    public abstract P add();


}
