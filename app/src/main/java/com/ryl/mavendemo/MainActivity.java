package com.ryl.mavendemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ryl.commonlib.utils.LU;
import com.ryl.commonlib.utils.ToastU;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LU.hd("asd","isOnDebug");
        ToastU.ht(MainActivity.this,"isDebug");
    }

}
