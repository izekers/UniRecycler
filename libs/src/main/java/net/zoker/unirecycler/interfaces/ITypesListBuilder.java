package net.zoker.unirecycler.interfaces;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/11/28.
 */

public interface ITypesListBuilder<VH extends RecyclerView.ViewHolder>{
    int getItemViewType(int position);

}
