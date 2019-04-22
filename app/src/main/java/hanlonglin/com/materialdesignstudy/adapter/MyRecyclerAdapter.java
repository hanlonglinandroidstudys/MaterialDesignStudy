package hanlonglin.com.materialdesignstudy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hanlonglin.com.materialdesignstudy.R;

public class MyRecyclerAdapter extends RecyclerView.Adapter {
    List<String> list;
    Context context;

    public MyRecyclerAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_title, parent, false);
        MyRecyclerHolder myRecyclerHolder = new MyRecyclerHolder(v);
        return myRecyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyRecyclerHolder) holder).txt_title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyRecyclerHolder extends RecyclerView.ViewHolder {
        TextView txt_title;

        public MyRecyclerHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
        }
    }

    public void addItem(String item) {
        list.add(item);
        notifyItemInserted(0);
    }

    public void deleteItem(int pos) {
        if (list.size() > (pos + 1)) {
            list.remove(pos);
            notifyItemRemoved(pos);
        }
    }
}
