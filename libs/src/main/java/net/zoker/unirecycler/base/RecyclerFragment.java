package net.zoker.unirecycler.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by zoker on 2017/12/1.
 */

public abstract class RecyclerFragment<Data,VH extends RecyclerView.ViewHolder> extends ListFragment<Data> {
    protected abstract RecyclerView.LayoutManager installLayoutManager();
    public abstract void onBindViewHolder(VH holder, int position);
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);
}
