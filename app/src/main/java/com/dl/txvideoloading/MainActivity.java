package com.dl.txvideoloading;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRefreshLoadmoreListener {

    private RecyclerView mRecyclerView;

    private List<String> mDatas = new ArrayList<>();

    private SmartRefreshLayout mSmartRefreshLayout;

    private CommonAdapter<String> adapter;

    private LoadingView mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.refresh);
        mSmartRefreshLayout.setOnRefreshLoadmoreListener(this);
        mLoadingView = (LoadingView) findViewById(R.id.loadingview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.item_list_title, s);
            }
        };
        mDatas.addAll(getDatas());
        mRecyclerView.setAdapter(adapter);

        mLoadingView.startAnim();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingView.stopAnim();
                mLoadingView.setVisibility(View.GONE);
            }
        },3000);
    }


    public List<String> getDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试数据的item" + i);
        }
        return list;
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.addAll(getDatas());
                adapter.notifyDataSetChanged();
                mSmartRefreshLayout.finishLoadmore();
            }
        }, 2000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.clear();
                mDatas.addAll(getDatas());
                adapter.notifyDataSetChanged();
                mSmartRefreshLayout.finishRefresh();
            }
        }, 2000);
    }
}
