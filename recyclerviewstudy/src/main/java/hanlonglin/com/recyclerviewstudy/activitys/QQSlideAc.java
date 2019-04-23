package hanlonglin.com.recyclerviewstudy.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import hanlonglin.com.recyclerviewstudy.R;
import hanlonglin.com.recyclerviewstudy.adapter.MyQQRecyclerAdapter;
import hanlonglin.com.recyclerviewstudy.bean.DataUtils;
import hanlonglin.com.recyclerviewstudy.callback.MyItemTouchCallback;
import hanlonglin.com.recyclerviewstudy.interfaces.ItemTouchMoveListener;
import hanlonglin.com.recyclerviewstudy.interfaces.StartDragListener;

public class QQSlideAc extends AppCompatActivity implements StartDragListener{


    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqslide);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView_qq = (RecyclerView) findViewById(R.id.recyclerView_qq);

        recyclerView_qq.setLayoutManager(new LinearLayoutManager(this));
        MyQQRecyclerAdapter myQQRecyclerAdapter = new MyQQRecyclerAdapter(DataUtils.initQQData(), this);
        recyclerView_qq.setAdapter(myQQRecyclerAdapter);

        //
        MyItemTouchCallback callback = new MyItemTouchCallback(myQQRecyclerAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView_qq);

    }

    @Override
    public void onStartDrager(RecyclerView.ViewHolder holder) {
        Log.e("TAG", "onStartDrager...");
        itemTouchHelper.startDrag(holder); //主动调用开始拖拽事件
    }

}
