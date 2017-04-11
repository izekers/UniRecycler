package net.zoker.unirecycler.base;


import android.util.SparseArray;

/**
 * 用于管理种类
 * Created by zhy on 16/6/22.
 */
public class ItemViewDelegateManager<T>{
    SparseArray<ItemViewDelegate<T>> delegates = new SparseArray();

    public int getItemViewDelegateCount()
    {
        return delegates.size();
    }

    public ItemViewDelegateManager<T> addDelegate(ItemViewDelegate<T> delegate){
        int viewType = delegates.size();
        if (delegate != null){
            delegates.put(viewType, delegate);
        }
        return this;
    }

    public ItemViewDelegateManager<T> addDelegate(int viewType, ItemViewDelegate<T> delegate)
    {
        //该index已经有类型了
        if (delegates.get(viewType) != null){
            throw new IllegalArgumentException(
                    "An ItemViewDelegate is already registered for the viewType = "
                            + viewType
                            + ". Already registered ItemViewDelegate is "
                            + delegates.get(viewType));
        }
        delegates.put(viewType, delegate);
        return this;
    }

    //移除种类
    public ItemViewDelegateManager<T> removeDelegate(ItemViewDelegate<T> delegate)
    {
        if (delegate == null)
        {
            throw new NullPointerException("ItemViewDelegate is null");
        }
        int indexToRemove = delegates.indexOfValue(delegate);

        if (indexToRemove >= 0)
        {
            delegates.removeAt(indexToRemove);
        }
        return this;
    }

    public ItemViewDelegateManager<T> removeDelegate(int itemType)
    {
        int indexToRemove = delegates.indexOfKey(itemType);

        if (indexToRemove >= 0)
        {
            delegates.removeAt(indexToRemove);
        }
        return this;
    }

    //这种方式与我之前使用的通过数据类型获取，通过种类工厂分类的方式各有千秋
    public int getItemViewType(T item, int position){
        int delegatesCount = delegates.size();
        //遍历一遍，查找出适合的ItemType
        for (int i = delegatesCount - 1; i >= 0; i--){
            ItemViewDelegate<T> delegate = delegates.valueAt(i);
            if (delegate.isForViewType(item, position)){
                return delegates.keyAt(i);
            }
        }
        //找不到就报错
        throw new IllegalArgumentException(
                "No ItemViewDelegate added that matches position=" + position + " in data source");
    }

    public void convert(SimplerViewHolder holder, T item, int position)
    {
        int delegatesCount = delegates.size();
        for (int i = 0; i < delegatesCount; i++)
        {
            ItemViewDelegate<T> delegate = delegates.valueAt(i);

            if (delegate.isForViewType(item, position)){
                delegate.convert(holder, item, position);
                return;
            }
        }
        throw new IllegalArgumentException(
                "No ItemViewDelegateManager added that matches position=" + position + " in data source");
    }


    //这里管理viewType类型
    public ItemViewDelegate getItemViewDelegate(int viewType)
    {
        return delegates.get(viewType);
    }

    public int getItemViewLayoutId(int viewType)
    {
        return getItemViewDelegate(viewType).getItemViewLayoutId();
    }

    public int getItemViewType(ItemViewDelegate itemViewDelegate)
    {
        return delegates.indexOfValue(itemViewDelegate);
    }
}
