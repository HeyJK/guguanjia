package com.chinasoft.guguanjia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hshuai on 2017/6/30.
 */

public class MyListViewAdapter extends BaseAdapter{
    private  Context mContext;
    private List<User> list;

    private ClickShowCallBack callBack;

    public MyListViewAdapter(Context context, List<User> list,ClickShowCallBack callBack){
        this.mContext=context;
        this.list=list;
        this.callBack=callBack;
//        LayoutInflater.from(context).inflate(R.layout.xlist_item,null);
    }

    public interface ClickShowCallBack{
        void click(User user);
    }

    //显示的条数
    @Override
    public int getCount() {
        return list.size();
    }
    //得到某一条数据
    @Override
    public User getItem(int position) {
        return list.get(position);
    }
    //得到某一条数据的位置
    @Override
    public long getItemId(int position) {
        return position;
    }
    //一条数据显示的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final User user= getItem(position);
        convertView=LayoutInflater.from(mContext).inflate(R.layout.xlist_item,null);
        TextView nameText=(TextView)convertView.findViewById(R.id.name);
        TextView ageText=(TextView)convertView.findViewById(R.id.age);
        TextView show=(TextView) convertView.findViewById(R.id.show);

        nameText.setText(user.getName());
        ageText.setText(""+user.getAge());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(mContext,UserDetailActivity.class);
                intent.putExtra("name",user.getName());
                intent.putExtra("age",user.getAge());
                mContext.startActivity(intent);*/
                callBack.click(user);
            }
        });

        return convertView;
    }
}
