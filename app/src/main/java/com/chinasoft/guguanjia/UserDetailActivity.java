package com.chinasoft.guguanjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        String name=getIntent().getStringExtra("name");
        int age=getIntent().getIntExtra("age",0);
        Toast.makeText(UserDetailActivity.this,name+"  "+ age ,Toast.LENGTH_SHORT).show();
    }
}
