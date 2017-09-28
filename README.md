# refreshLayout
支持 下拉刷新， recyclerview listview scrollview  和各种layout


## listview

![listview](https://github.com/wanghao200906/refreshLayout/raw/master/images/listview.gif)


## recyclerview
![recyclerview](https://github.com/wanghao200906/refreshLayout/raw/master/images/recyclerview.gif)


##使用方法

###xml
 
 ```
 <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:orientation="vertical">
  
      <refresh.RefreshLayout
          android:id="@+id/refresh_layout"
          android:layout_width="match_parent"
          android:layout_height="match_parent">
  
          <android.support.v7.widget.RecyclerView
              android:id="@+id/recycleview"
              android:layout_width="match_parent"
              android:layout_height="match_parent" />
      </refresh.RefreshLayout>
  
  </LinearLayout>
  ```
### 代码中

```
        final refresh.RefreshLayout refreshLayout = (refresh.RefreshLayout) findViewById(R.id.refresh_layout);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       
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
```

 