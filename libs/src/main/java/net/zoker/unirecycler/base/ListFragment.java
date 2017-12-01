package net.zoker.unirecycler.base;


import android.support.v4.app.Fragment;

import net.zoker.unirecycler.interfaces.IListBuider;

import java.util.List;

/**
 * Created by zoker on 2017/11/30.
 */

public abstract class ListFragment<Data> extends Fragment implements IListBuider<Data> {
    private List<Data> mData;
    protected abstract void notifyDataSetChanged();

    @Override
    public void addData(List<Data> mdata) {
        if (this.mData == null)
            this.mData = mdata;
        else
            this.mData.addAll(mdata);
        notifyDataSetChanged();
    }

    @Override
    public void setData(List<Data> mdata) {
        clear();
        this.mData = mdata;
        notifyDataSetChanged();
    }

    @Override
    public void clear() {
        if (this.mData != null)
            this.mData.clear();
        notifyDataSetChanged();
    }

    @Override
    public Data getItemData(int position) {
        if (mData == null)
            return null;
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }
}
