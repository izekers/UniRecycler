package net.zoker.unirecycler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.zoker.unirecycler.base.RecyclerFragment;

/**
 * Created by Administrator on 2017/11/28.
 */
public abstract class SingleListFragment<Data, VH extends RecyclerView.ViewHolder> extends RecyclerFragment<Data, VH> {
    private RecyclerView rootView;
    private Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = new RecyclerView(getContext());
        rootView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rootView.setLayoutManager(installLayoutManager());
        rootView.setAdapter(adapter = new Adapter());
    }

    @Override
    protected RecyclerView.LayoutManager installLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    private class Adapter extends RecyclerView.Adapter<VH> {
        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return SingleListFragment.this.onCreateViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            SingleListFragment.this.onBindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return SingleListFragment.this.getItemCount();
        }
    }


    protected void notifyDataSetChanged() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateViewHolder(parent);
    }

    public abstract VH onCreateViewHolder(ViewGroup parent);
}
