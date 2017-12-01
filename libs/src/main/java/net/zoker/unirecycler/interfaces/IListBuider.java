package net.zoker.unirecycler.interfaces;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import net.zoker.unirecycler.base.UniItemViewBinder;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by zoker on 2017/11/28.
 */

public interface IListBuider<Data>{
    void setData(List<Data> mdata);
    void addData(List<Data> mdata);
    void clear();
    Data getItemData(int position);
    int getItemCount();
}
