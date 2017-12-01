package net.zoker.unirecycler.base;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zoker on 2017/11/30.
 */

public abstract class UniViewHolder<Data> extends RecyclerView.ViewHolder {
    public UniViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        this(LayoutInflater.from(parent.getContext()).inflate(layoutRes, parent, false));
    }

    public UniViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setData(Data data);
}
