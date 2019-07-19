package com.dragonforest.android.viewstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dragonforest.android.viewstudy.StudyColorFilter.activity.ColorFilterTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_colorFilter:
                go(ColorFilterTestActivity.class);
                break;
        }
    }

    private void go(Class clazz){
        startActivity(new Intent(MainActivity.this,clazz));
    }
}

