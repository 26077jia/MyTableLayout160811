package com.myexample.jiajia.mytablelayout160811;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajia on 2016/8/11.
 */
public class TopTabActivity extends BaseActivity{
    private TabLayout tl_top_bar;
    private ViewPager vp_top_bar;

    List<String> tabIndicators;
    List<Fragment> tabFragments;
    MyContentFragmentAdapter myContentFragmentAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_top_tab);
        initView();
        initEvent();
    }

    public void initView() {
        tl_top_bar = (TabLayout) findViewById(R.id.tl_top_tab);
        vp_top_bar = (ViewPager) findViewById(R.id.vp_top_tab);
        /* 设置tabLayout的样式 */
        tl_top_bar.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl_top_bar.setTabTextColors(ContextCompat.getColor(this,R.color.darkGray),ContextCompat.getColor(this,R.color.white));
        tl_top_bar.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.white));
    }

    public void initEvent() {
        tabIndicators = new ArrayList<>();
        tabFragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabIndicators.add("tab"+i);
        }
        for (String str : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(str));//创建fragment并添加
        }
        myContentFragmentAdapter = new MyContentFragmentAdapter(getSupportFragmentManager());
        vp_top_bar.setAdapter(myContentFragmentAdapter);

        tl_top_bar.setupWithViewPager(vp_top_bar);
    }

    class MyContentFragmentAdapter extends FragmentPagerAdapter{
        public MyContentFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabIndicators.get(position);
        }
    }
}
