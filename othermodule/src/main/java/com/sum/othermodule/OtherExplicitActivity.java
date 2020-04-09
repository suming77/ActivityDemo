package com.sum.othermodule;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 应用程序2的显式Activity
 *
 * 应用程序1通过setClassName(String packageName, String className)指定显式应用程序包名和类名跳转到应用2的Activity
 */
public class OtherExplicitActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_explicit);
    }
}
