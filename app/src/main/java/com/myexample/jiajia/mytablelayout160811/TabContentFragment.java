package com.myexample.jiajia.mytablelayout160811;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jiajia on 2016/8/11.
 */
public class TabContentFragment extends Fragment{
    private static String CONTENT="content";
    public static TabContentFragment newInstance(String content) {

        Bundle args = new Bundle();
        args.putString("CONTENT" , content);
        TabContentFragment fragment = new TabContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pages,null);
        ((TextView)view.findViewById(R.id.tv_fragment_page)).setText(getArguments().getString(CONTENT));
        return view;
    }
}
