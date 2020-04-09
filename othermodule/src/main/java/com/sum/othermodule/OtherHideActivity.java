package com.sum.othermodule;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 应用程序2的隐式Activity
 *
 * 应用程序1通过指定action、category、data跳转到应用2的Activity
 */
public class OtherHideActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_hide);
    }
}
