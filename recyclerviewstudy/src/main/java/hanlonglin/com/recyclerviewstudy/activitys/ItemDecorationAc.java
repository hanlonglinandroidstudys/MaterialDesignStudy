package hanlonglin.com.recyclerviewstudy.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import hanlonglin.com.recyclerviewstudy.R;
import hanlonglin.com.recyclerviewstudy.adapter.MyRecyclerAdapter;
import hanlonglin.com.recyclerviewstudy.itemDecoration.DividerItemDecoration;
import hanlonglin.com.recyclerviewstudy.itemDecoration.GridDividerItemDecoration;

public class ItemDecorationAc extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn_add, btn_remove;
    Button btn_linear, btn_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        initView();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_remove = (Button) findViewById(R.id.btn_remove);
        btn_grid = (Button) findViewById(R.id.btn_grid);
        btn_linear = (Button) findViewById(R.id.btn_linear);

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

        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLinear();
            }
        });

        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGrid();
            }
        });

        //默认显示线性
        showLinear();
    }

    private void showLinear() {
        if (recyclerView.getItemDecorationCount() > 0)
            recyclerView.removeItemDecorationAt(0); //重置
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("标题" + i);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private void showGrid() {
        if (recyclerView.getItemDecorationCount() > 0)
            recyclerView.removeItemDecorationAt(0);//重置
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("标题" + i);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new GridDividerItemDecoration(this, 3));
    }
}
