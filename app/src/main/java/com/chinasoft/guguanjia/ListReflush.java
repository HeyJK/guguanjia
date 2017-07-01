package com.chinasoft.guguanjia;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListReflush extends Activity {
    private XListView xListView;
    private TextView showName;
    private MyListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reflush);
        xListView = (XListView) findViewById(R.id.myXListView);
        showName = (TextView) findViewById(R.id.showName);


        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("张三" + i);
            user.setAge(20 + i);
            user.setSex(i % 2 == 0 ? "男" : "女");
            list.add(user);
        }

        mAdapter = new MyListViewAdapter(ListReflush.this, list, new MyListViewAdapter.ClickShowCallBack() {
            @Override
            public void click(User user) {
                showName.setText(user.getName());
            }
        });
        //设置是否允许刷新或加载更多,默认为true
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);


        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                Date date = new Date();
                xListView.setRefreshTime(sdf.format(date));
                List<User> list1 = new ArrayList<User>();
                for (int i = 0; i < 10; i++) {
                    User user1 = new User();
                    user1.setId(i);
                    user1.setName("李四" + i);
                    user1.setAge(20 + i);
                    user1.setSex(i % 2 == 1 ? "男" : "女");
                    list1.add(user1);
                }
                mAdapter = new MyListViewAdapter(ListReflush.this, list1, new MyListViewAdapter.ClickShowCallBack() {
                    @Override
                    public void click(User user) {
                        showName.setText(user.getName());
                    }
                });
                xListView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                xListView.stopRefresh();
            }

            @Override
            public void onLoadMore() {

                xListView.stopLoadMore();
            }
        });

        xListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListReflush.this, "长按删除", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListReflush.this, "一不注意按了一下", Toast.LENGTH_SHORT).show();
            }
        });


        xListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
