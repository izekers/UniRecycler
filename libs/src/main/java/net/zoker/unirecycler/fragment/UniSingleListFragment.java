package net.zoker.unirecycler.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.zoker.unirecycler.base.UniViewHolder;

/**
 * 简化版ListFragment
 * Created by Zoker on 2017/11/28.
 */

public abstract class UniSingleListFragment<Data, VH extends UniViewHolder<Data>> extends SingleListFragment<Data, VH> {
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setData(getItemData(position));
    }

    @Override
    protected RecyclerView.LayoutManager installLayoutManager() {
        return new LinearLayoutManager(getContext());
    }
}
