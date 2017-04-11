package net.zoker.unirecycler.base;


import android.view.View;

/**
 * itemType接口
 * Created by zhy on 16/6/22.
 */
public interface ItemViewDelegate<T>
{
    //设置itemType的LayoutId
    int getItemViewLayoutId();

    //判断相同数据类型下怎么区分是否同一种View
    boolean isForViewType(T item, int position);

    //填充数据
    void convert(SimplerViewHolder holder, T t, int position);

}
