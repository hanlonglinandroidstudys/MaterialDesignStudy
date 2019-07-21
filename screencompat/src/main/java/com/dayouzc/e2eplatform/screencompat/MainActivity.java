package com.dayouzc.e2eplatform.screencompat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dayouzc.e2eplatform.screencompat.com.screen.activity.CompatActivity;
import com.dayouzc.e2eplatform.screencompat.com.screen.activity.NormalActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_compat:
                go(CompatActivity.class);
                break;
            case R.id.btn_normal:
                go(NormalActivity.class);
                break;
            default:
                break;
        }
    }

    private void go(Class clazz){
        startActivity(new Intent(MainActivity.this,clazz));
    }
}