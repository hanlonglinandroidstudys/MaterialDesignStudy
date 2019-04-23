package hanlonglin.com.recyclerviewstudy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import hanlonglin.com.recyclerviewstudy.R;
import hanlonglin.com.recyclerviewstudy.activitys.QQSlideAc;
import hanlonglin.com.recyclerviewstudy.bean.QQMessage;
import hanlonglin.com.recyclerviewstudy.interfaces.ItemTouchMoveListener;
import hanlonglin.com.recyclerviewstudy.interfaces.StartDragListener;

public class MyQQRecyclerAdapter extends RecyclerView.Adapter implements ItemTouchMoveListener {
    private final StartDragListener startDragListener;
    List<QQMessage> list;

    public MyQQRecyclerAdapter(List<QQMessage> list, StartDragListener startDragListener) {
        this.list = list;
        this.startDragListener =startDragListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qq,parent,false);
        MyQQViewHolder holder=new MyQQViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        ((MyQQViewHolder)holder).txt_from.setText(list.get(position).getFromName());
        ((MyQQViewHolder)holder).txt_content.setText(list.get(position).getContent());
        ((MyQQViewHolder)holder).img_qq.setImageResource(list.get(position).getImgId());
        ((MyQQViewHolder)holder).img_qq.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    startDragListener.onStartDrager(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onItemMove(int from, int to) {
        //1.交换数据
        Collections.swap(list,from,to);
        //2.刷新
        notifyItemMoved(from,to);
        Log.e("TAG","交换数据：from:"+from+",to:"+to);
        return false;
    }

    @Override
    public boolean onItemRemove(int pos) {
        //1.删除数据
        list.remove(pos);
        //2.刷新
        notifyItemRemoved(pos);
        return false;
    }

    public static class MyQQViewHolder extends RecyclerView.ViewHolder{

        TextView txt_from;
        TextView txt_content;
        ImageView img_qq;
        public MyQQViewHolder(View itemView) {
            super(itemView);
            txt_content=itemView.findViewById(R.id.txt_content);
            txt_from=itemView.findViewById(R.id.txt_from);
            img_qq=itemView.findViewById(R.id.img_qq);
        }

    }
}
