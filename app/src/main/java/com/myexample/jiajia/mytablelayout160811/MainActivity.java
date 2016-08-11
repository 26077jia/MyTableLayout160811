package com.myexample.jiajia.mytablelayout160811;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_top_tab,btn_bottom_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initView();
        initEvent();
    }

    public void initView() {
        btn_top_tab  = (Button) findViewById(R.id.btn_main_toptab);
        btn_bottom_tab = (Button) findViewById(R.id.btn_main_bottomtab);
    }

    public void initEvent() {
        btn_top_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TopTabActivity.class);
                startActivity(intent);
            }
        });
        btn_bottom_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BottomTabActivity.class);
                startActivity(intent);
            }
        });
    }
}
