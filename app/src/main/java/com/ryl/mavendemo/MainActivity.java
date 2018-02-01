package com.ryl.mavendemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ryl.commonlib.utils.PromissionResult;
import com.ryl.commonlib.utils.LU;
import com.ryl.commonlib.utils.PromisionU;
import com.ryl.commonlib.utils.ToastU;

public class MainActivity extends AppCompatActivity {


    private String[] promissions = {"android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LU.hd("asd", "isOnDebug");
        ToastU.ht(MainActivity.this, "isDebug");


        PromissionResult.CheckPermissionResult result = PromisionU.checkPromissions(
                MainActivity.this, promissions, 3);
        if (result == PromissionResult.CheckPermissionResult.ACCESS ||
                result == PromissionResult.CheckPermissionResult.SDK_LOWER) {
            ToastU.toast(MainActivity.this, "getAll");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      PromisionU.PromissionRequestResult result=  PromisionU.isSuccess(grantResults, permissions);

      if (result.isSuccess){
          ToastU.toast(MainActivity.this,"requestSuccess");
      }else{
          ToastU.toast(MainActivity.this,"fail_"+result.getFailLists().get(0));
      }
    }
}
