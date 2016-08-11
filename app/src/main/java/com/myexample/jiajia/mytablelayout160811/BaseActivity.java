package com.myexample.jiajia.mytablelayout160811;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by jiajia on 2016/8/11.
 */
public class BaseActivity extends AppCompatActivity{
    private Toolbar toolbar;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        toolbar = (Toolbar)findViewById(R.id.tlb_comm);


    }
}
