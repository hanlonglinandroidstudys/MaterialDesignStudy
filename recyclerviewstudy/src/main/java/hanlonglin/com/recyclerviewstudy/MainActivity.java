package hanlonglin.com.recyclerviewstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hanlonglin.com.recyclerviewstudy.activitys.AddHeaderAc;
import hanlonglin.com.recyclerviewstudy.activitys.ItemDecorationAc;
import hanlonglin.com.recyclerviewstudy.activitys.QQSlideAc;
import hanlonglin.com.recyclerviewstudy.activitys.QQSlideAc2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_itemDecoration:
                go(ItemDecorationAc.class);
                break;
            case R.id.btn_goto_addHeader:
                go(AddHeaderAc.class);
                break;
            case R.id.btn_goto_qq:
                go(QQSlideAc.class);
                break;
            case R.id.btn_goto_qq2:
                go(QQSlideAc2.class);
                break;
        }
    }

    private void go(Class clazz) {
        startActivity(new Intent(MainActivity.this, clazz));
    }
}
