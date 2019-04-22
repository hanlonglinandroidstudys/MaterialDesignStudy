package hanlonglin.com.materialdesignstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import hanlonglin.com.materialdesignstudy.adapter.MyRecyclerAdapter;
import hanlonglin.com.materialdesignstudy.decoration.GridDividerItemDecoration;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn_add, btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_remove = (Button) findViewById(R.id.btn_remove);

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyRecyclerAdapter) recyclerView.getAdapter()).deleteItem(0);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyRecyclerAdapter) recyclerView.getAdapter()).addItem("新建的");
            }
        });

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("标题" + i);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, this);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
//        recyclerView.setAdapter(adapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new GridDividerItemDecoration(this,3));
    }
}
