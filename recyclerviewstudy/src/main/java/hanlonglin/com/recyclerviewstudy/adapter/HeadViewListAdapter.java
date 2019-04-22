package hanlonglin.com.recyclerviewstudy.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HeadViewListAdapter extends RecyclerView.Adapter {

    private final static int VIEW_TYPE_HEADER = 0;
    private final static int VIEW_TYPE_ITEM = 1;
    private final static int VIEW_TYPE_FOOTER = 2;
    private final static int VIEW_TYPE_NONE = -1;


    RecyclerView.Adapter mAdapter;
    List<View> mHeaderViewInfos;
    List<View> mFooterViewInfos;

    public HeadViewListAdapter(List<View> mHeaderViewInfos, List<View> mFooterViewInfos, RecyclerView.Adapter mAdapter) {
        this.mAdapter = mAdapter;
        this.mHeaderViewInfos = mHeaderViewInfos;
        this.mFooterViewInfos = mFooterViewInfos;
    }

    @Override
    public int getItemViewType(int position) {
        // Header (negative positions will throw an IndexOutOfBoundsException)
        int numHeaders = getHeadersCount();

        //header部分
        if (position < numHeaders) {
            return VIEW_TYPE_HEADER;
        }
        //正常部分
        if (mAdapter != null) {
            int numItems = mAdapter.getItemCount();
            if (position >= numHeaders && position < (numHeaders + numItems)) {
                return VIEW_TYPE_ITEM;
            }
        }
        //footer部分
        return VIEW_TYPE_FOOTER;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return mAdapter.onCreateViewHolder(parent, viewType);

        switch (viewType) {
            case VIEW_TYPE_HEADER:
                View headerView = mHeaderViewInfos.get(0);
                return new HeaderViewHolder(headerView);
            case VIEW_TYPE_FOOTER:
                View footerView = mFooterViewInfos.get(0);
                return new HeaderViewHolder(footerView);
            case VIEW_TYPE_ITEM:
                return mAdapter.onCreateViewHolder(parent, viewType);
            case VIEW_TYPE_NONE:
                return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //也要分三个区域
        //header
        int numHeaders=getHeadersCount();
        if(position<numHeaders)  //是头部
            return ;

        //正常部分
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mAdapter.onBindViewHolder( holder, adjPosition);
                return ;
            }
        }
        //footer


    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getItemCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    public void updataDataChanged(List<View> mHeaderViewInfos, List<View> mFooterViewInfos) {
        this.mHeaderViewInfos = mHeaderViewInfos;
        this.mFooterViewInfos = mFooterViewInfos;
        notifyDataSetChanged();
    }

    public int getFootersCount() {
        return mFooterViewInfos.size();
    }

    public int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
