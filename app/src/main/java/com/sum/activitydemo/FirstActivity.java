package com.sum.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * FirstActivity
 */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findViewById(R.id.tv_result).setOnClickListener(this);

        //获取传递的数据，getIntent()获取Intent，getXXXExtra()获取对应类型数据
        String name = getIntent().getStringExtra("name");
        int type = getIntent().getIntExtra("type", 0);
        Person person = (Person) getIntent().getSerializableExtra("person");

        Log.e(TAG, "name == " + name);
        Log.e(TAG, "type == " + type);
        Log.e(TAG, "person == " + person);
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent().putExtra("return", "FirstActivity销毁后回传数据");
        setResult(101, intent);
        finish();
    }
}
