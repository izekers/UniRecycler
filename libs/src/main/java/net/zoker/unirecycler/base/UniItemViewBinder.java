package net.zoker.unirecycler.base;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by zoker on 2017/11/30.
 */

public abstract class UniItemViewBinder<Data, VH extends UniViewHolder<Data>> extends ItemViewBinder<Data, VH> {

    @Override
    protected void onBindViewHolder(@NonNull VH holder, @NonNull Data item) {
        holder.setData(item);
    }
}
