package com.example.mypro.refreshlayout.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mypro.refreshlayout.R;

import java.util.ArrayList;
import java.util.List;

import refresh.interfaces.OnRefListener;
import refresh.RefreshLayout;

/**
 * Created by wanghao on 2017/9/12.
 */

public class ListViewActivity extends AppCompatActivity {

    private List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        initData();
        init();
    }

    private void initData() {
        listData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            listData.add("item:" + i);
        }
    }

    private void init() {
        final refresh.RefreshLayout refreshLayout = (refresh.RefreshLayout) findViewById(R.id.refresh_layout);
        final ListView listview = (ListView) findViewById(R.id.list_view);
        refreshLayout.setEnableDisVerification(true);
        View view = LayoutInflater.from(this).inflate(com.wh.reflayout.R.layout.ptr_empty_view, null, false);

        refreshLayout.showEmptyView(view);
        refreshLayout.setOnPtrListener(new OnRefListener() {
            @Override
            public void onRefresh(RefreshLayout view) {
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.completeRefuse();
                        refreshLayout.showContentView();
                    }
                }, 1000);
            }
        });
        listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData));
    }
}
