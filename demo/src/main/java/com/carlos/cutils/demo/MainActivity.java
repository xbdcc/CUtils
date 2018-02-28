package com.carlos.cutils.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.carlos.cutils.view.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ToastUtil.Builder(MainActivity.this).setText("test").build();

    }
}
