package hanlonglin.com.recyclerviewstudy.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hanlonglin.com.recyclerviewstudy.R;
import hanlonglin.com.recyclerviewstudy.adapter.MyRecyclerAdapter;
import hanlonglin.com.recyclerviewstudy.view.WrapRecyclerView;

public class AddHeaderAc extends AppCompatActivity {

    private Button btn_addHeader;
    private Button btn_addFooter;
    private WrapRecyclerView wrapRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_header);

        initView();
    }

    private void initView() {
        btn_addHeader = (Button) findViewById(R.id.btn_addHeader);
        btn_addFooter = (Button) findViewById(R.id.btn_addFooter);
        wrapRecyclerView = (WrapRecyclerView) findViewById(R.id.wrapRecyclerView);
        wrapRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        initRecyclerViewData();

        btn_addFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFooter();
            }
        });

        btn_addHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHeader();
            }
        });
    }

    private void addFooter() {
        TextView txt_head=new TextView(this);
        RecyclerView.LayoutParams params= new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txt_head.setLayoutParams(params);
        txt_head.setText("我是头部");

        wrapRecyclerView.addHeaderView(txt_head);

    }

    private void addHeader() {
        TextView txt_Footer=new TextView(this);
        RecyclerView.LayoutParams params= new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txt_Footer.setLayoutParams(params);
        txt_Footer.setText("我是尾部");

        wrapRecyclerView.addFooterView(txt_Footer);
    }

    private void initRecyclerViewData() {
        addHeader();
        addFooter();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add("标题：" + i);
        }
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(list, this);
        wrapRecyclerView.setAdapter(adapter);
    }
}
