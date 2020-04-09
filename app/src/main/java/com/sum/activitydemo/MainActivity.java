package com.sum.activitydemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 我的博客：https://blog.csdn.net/m0_37796683
 * Activity详解（一）
 * Activity创建、清单文件注册、显式隐式意图、数据传递
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_name = findViewById(R.id.tv_name);
        findViewById(R.id.btn_first).setOnClickListener(this);
        findViewById(R.id.btn_explicit_other).setOnClickListener(this);
        findViewById(R.id.btn_hide_system).setOnClickListener(this);
        findViewById(R.id.btn_hide_other).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //注意，先将OtherModule运行安装在手机中
        switch (v.getId()) {
            case R.id.btn_first://显式意图启动
                //跳转同一项目下的Activity，直接指定该Activity的字节码即可。
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                intent.putExtra("name", "陈奕迅");
                intent.putExtra("type", 1001);
                intent.putExtra("person", new Person("歌神"));
//                startActivity(intent);
                startActivityForResult(intent, 100);//带回传结果的启动Activity
                break;
            case R.id.btn_explicit_other://显式意图启动
                //跳转到其他应用的Activity，需要指定应用包名和该类的全局类名，这种适用于第三方应用且知道界面类名的情况
                //这里跳转到OtherModule中的OtherExplicitActivity
                Intent intent2 = new Intent();
                //指定显式应用程序包名和类名
                //packageName表示所需包的名称，即包名。
                //className表示应用程序包内将用作此Intent的组件的类的名称。
                intent2.setClassName("com.sum.othermodule", "com.sum.othermodule.OtherExplicitActivity");
                startActivity(intent2);
                break;
            case R.id.btn_hide_system://隐式意图启动
                //隐式意图跳转到系统的界面，发送信息
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SENDTO);//发送信息action
                i.addCategory("android.intent.category.DEFAULT");//默认Category
                i.setData(Uri.parse("smsto:10086"));//设置动作附加的数据，Uri.parse()将字符串转成URI对象
                startActivity(i);
                break;
            case R.id.btn_hide_other://隐式意图启动
                //隐式意图跳转到自定义的界面，OtherModule中的OtherHideActivity
                Intent i2 = new Intent();
                i2.setAction("com.sum.othermodule.hide");//必须与清单文件中的action值相匹配
                i2.addCategory("android.intent.category.DEFAULT");//必须与清单文件中的category值相匹配
                startActivity(i2);
                break;
            default:
                break;
        }
    }

    //数据回传相应的方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100 && resultCode == 101 && data != null) {
            Log.e(TAG, "requestCode == " + requestCode + " | resultCode == " + resultCode + " | data == " + data.getStringExtra("return"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
