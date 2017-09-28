package com.example.mypro.refreshlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mypro.refreshlayout.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button list_view_refresh;
    Button recycleview_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list_view_refresh = (Button) findViewById(R.id.list_view_refresh);
        recycleview_refresh = (Button) findViewById(R.id.recycleview_refresh);

        list_view_refresh.setOnClickListener(this);
        recycleview_refresh.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.list_view_refresh:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;
            case R.id.recycleview_refresh:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;

        }
    }
}
