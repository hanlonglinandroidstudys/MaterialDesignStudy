package hanlonglin.com.recyclerviewstudy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;
import java.util.List;

import hanlonglin.com.recyclerviewstudy.adapter.HeadViewListAdapter;

/**
 * 支持添加头部和尾部的RecyclerView
 */
public class WrapRecyclerView extends RecyclerView {

    List<View> mHeaderViewInfos = new ArrayList<>();
    List<View> mFooterViewInfos = new ArrayList<>();
    Adapter mAdapter;

    public WrapRecyclerView(Context context) {
        super(context);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Add a fixed view to appear at the top of the list. If this method is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p>
     * Note: When first introduced, this method could only be called before
     * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
     * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
     * called at any time. If the ListView's adapter does not extend
     * {@link HeaderViewListAdapter}, it will be wrapped with a supporting
     * instance of {@link WrapperListAdapter}.
     *
     * @param v            The view to add.
     * @param data         Data to associate with this view
     * @param isSelectable whether the item is selectable
     */
    public void addHeaderView(View v) {

        mHeaderViewInfos.add(v);
        // Wrap the adapter if it wasn't already wrapped.
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeadViewListAdapter)) {
                mAdapter = new HeadViewListAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }else {
                ((HeadViewListAdapter) mAdapter).updataDataChanged(mHeaderViewInfos, mFooterViewInfos);
            }
            // In the case of re-adding a header view, or adding one later on,
            // we need to notify the observer.
//            if (mDataSetObserver != null) {
//                mDataSetObserver.onChanged();
//            }
        }
    }

    public void addFooterView(View v) {

        mFooterViewInfos.add(v);
        // Wrap the adapter if it wasn't already wrapped.
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeadViewListAdapter)) {
                mAdapter = new HeadViewListAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            } else {
                ((HeadViewListAdapter) mAdapter).updataDataChanged(mHeaderViewInfos, mFooterViewInfos);
            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0) {
            mAdapter = new HeadViewListAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
        } else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);
    }


}
