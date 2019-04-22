package hanlonglin.com.materialdesignstudy;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_swiperefresh:
                go(SwipeActivity.class);
                break;
            case R.id.btn_recyclerView:
                go(RecyclerViewActivity.class);
                break;
        }
    }

    private void go(Class clazz) {
        startActivity(new Intent(MainActivity.this, clazz));
    }
}
