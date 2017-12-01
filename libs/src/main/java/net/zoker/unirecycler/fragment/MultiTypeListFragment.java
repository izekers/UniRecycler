package net.zoker.unirecycler.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.zoker.unirecycler.base.ListFragment;

import java.util.HashMap;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import me.drakeet.multitype.OneToManyFlow;

import static me.drakeet.multitype.MultiTypeAsserts.assertAllRegistered;
import static me.drakeet.multitype.MultiTypeAsserts.assertHasTheSameAdapter;

/**
 * Created by zoker on 2017/11/30.
 */

public abstract class MultiTypeListFragment extends ListFragment<Object> {
    private RecyclerView rootView;
    private Items items = new Items();
    private MultiTypeAdapter adapter;

    protected RecyclerView.LayoutManager installLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = new RecyclerView(getContext());
        rootView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.setLayoutManager(installLayoutManager());
        rootView.setAdapter(adapter = new MultiTypeAdapter());

//        /* 断言 recyclerView 使用的是正确的 adapter */
//        assertHasTheSameAdapter(rootView, adapter);

        adapter.setItems(items);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        installType();
    }

    public <T> void register(@NonNull Class<? extends T> clazz, @NonNull ItemViewBinder<T, ? extends RecyclerView.ViewHolder> binder) {
        adapter.register(clazz, binder);
    }
    public <T> OneToManyFlow<T> register(@NonNull Class<? extends T> clazz) {
        return adapter.register(clazz);
    }

    public abstract void installType();

    protected void notifyDataSetChanged() {
        if(items!=null && !items.isEmpty())
//        /* 断言所有使用的类型都已注册 */
//        assertAllRegistered(adapter, items);

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void addData(List<Object> mdata) {
        if (items == null) {
            setData(mdata);
        } else
            items.addAll(mdata);
        notifyDataSetChanged();
    }

    @Override
    public void setData(List<Object> mdata) {
        clear();
        items.addAll(mdata);
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @Override
    public Object getItemData(int position) {
        if (items == null || items.isEmpty())
            return null;
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }
}
