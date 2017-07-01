package com.chinasoft.guguanjia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private RelativeLayout login,findpw;
    private EditText phone,pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局文件
        setContentView(R.layout.activity_main);
        myClick();
    }

    public void myClick(){
        //根据id获取控件信息
        login= (RelativeLayout)findViewById(R.id.login_layout);
        findpw=(RelativeLayout) findViewById(R.id.findpw_layout);

        phone=(EditText) findViewById(R.id.phoneEdit);
        pw=(EditText) findViewById(R.id.pw);
        //获取输入框的值
        // phone.getText().toString()
        //phone.getText().toString().trim()去掉字符串前后的空格

        //第一种绑定点击事件方法
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"点击登录",Toast.LENGTH_SHORT).show();
            }
        });

        //第二种方式
        findpw.setOnClickListener(new FindpwClick());

        //第三种
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_layout:
                Toast.makeText(MainActivity.this,"点击登录,用户手机号码为："+phone.getText().toString().trim()+
                        "用户密码为："+pw.getText().toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.findpw_layout:
                Toast.makeText(MainActivity.this,"点击了找回密码1",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    class FindpwClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this,"点击了找回密码",Toast.LENGTH_SHORT).show();
        }
    }


}

