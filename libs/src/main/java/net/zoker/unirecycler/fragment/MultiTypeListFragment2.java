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
import net.zoker.unirecycler.base.UniViewHolder;

import java.util.List;

/**
 * Created by zoker on 2017/11/28.
 */

public abstract class MultiTypeListFragment2 extends RecyclerFragment<Object, RecyclerView.ViewHolder> {
    private RecyclerView rootView;
    private TypeAdapter adapter;

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
        rootView.setAdapter(adapter = new TypeAdapter());
    }

    public class TypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return MultiTypeListFragment2.this.onCreateViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MultiTypeListFragment2.this.onBindViewHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return MultiTypeListFragment2.this.getItemCount();
        }

        @Override
        public int getItemViewType(int position) {
            return MultiTypeListFragment2.this.getItemViewType(position);
        }
    }

    public RecyclerView getRootView() {
        return rootView;
    }

    public TypeAdapter getAdapter() {
        return adapter;
    }

    public abstract int getItemViewType(int position);

    @Override
    protected RecyclerView.LayoutManager installLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected void notifyDataSetChanged() {
        if (adapter != null)
            adapter.notifyDataSetChanged();
    }
}
