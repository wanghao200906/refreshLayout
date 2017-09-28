package com.example.mypro.refreshlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import refresh.RefreshLayout;
import refresh.interfaces.OnRefListener;

/**
 * Created by wanghao on 2017/9/28.
 */

public class RecycleViewActivity extends AppCompatActivity {

    private List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview);

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
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setEnableDisVerification(true);
        View view = LayoutInflater.from(this).inflate( R.layout.empty_view, null, false);
        refreshLayout.showEmptyView(view);
        refreshLayout.setOnPtrListener(new OnRefListener() {
            @Override
            public void onRefresh(RefreshLayout view) {
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.completeRefuse();
                        refreshLayout.showContentView();
                        recyclerView.setAdapter(new MyAdapter(listData));
                    }
                }, 1000);
            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<String> mData;

        public MyAdapter(List<String> data) {
            this.mData = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 实例化展示的view
            View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            // 实例化viewholder
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // 绑定数据
            holder.mTv.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView mTv;

            public ViewHolder(View itemView) {
                super(itemView);
                mTv = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}
