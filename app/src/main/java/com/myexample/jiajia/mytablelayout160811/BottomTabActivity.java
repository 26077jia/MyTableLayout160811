package com.myexample.jiajia.mytablelayout160811;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajia on 2016/8/11.
 */
public class BottomTabActivity  extends BaseActivity{
    private TabLayout tl_bottom;
    private ViewPager vp_bottom;

    List<String> tabIndicators;
    List<Fragment> tabFragments;
    MyFragmentAdapter myFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_bottom_tab);
        initView();
        initEvent();
    }

    private void initView() {
        tl_bottom = (TabLayout) findViewById(R.id.tl_bottom_tab);
        vp_bottom = (ViewPager) findViewById(R.id.vp_bottom_tab);

        tl_bottom.setTabMode(TabLayout.MODE_FIXED);
        tl_bottom.setSelectedTabIndicatorHeight(0);
    }

    private void initEvent() {
        tabIndicators = new ArrayList<>();
        tabFragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tabIndicators.add("tab"+i);
        }
        for (String str : tabIndicators) {
            tabFragments.add(TabContentFragment.newInstance(str));
        }
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        vp_bottom.setAdapter(myFragmentAdapter);
        tl_bottom.setupWithViewPager(vp_bottom);
        //设置tabitem 的样式
        for (int i = 0; i < tabIndicators.size(); i++) {
            TabLayout.Tab itemTab = tl_bottom.getTabAt(i);
            if (itemTab != null){
                itemTab.setCustomView(R.layout.item_bottom_tab);
                TextView tv_itemtab = (TextView) itemTab.getCustomView().findViewById(R.id.tv_bottom_tab);
                tv_itemtab.setText(tabIndicators.get(i));
            }
        }
        tl_bottom.getTabAt(0).getCustomView().setSelected(true);//设置默认选中第一个tab

    }
    class MyFragmentAdapter extends FragmentPagerAdapter{
        public MyFragmentAdapter(FragmentManager fm) {
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
