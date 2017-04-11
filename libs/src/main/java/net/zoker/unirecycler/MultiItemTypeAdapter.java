package net.zoker.unirecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.zoker.unirecycler.base.ItemViewDelegate;
import net.zoker.unirecycler.base.ItemViewDelegateManager;
import net.zoker.unirecycler.base.SimplerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<SimplerViewHolder> {
    protected Context mContext;
    protected List<T> mDatas;

    protected ItemViewDelegateManager mItemViewDelegateManager;
    protected OnItemClickListener mOnItemClickListener;


    public MultiItemTypeAdapter(Context context, List<T> datas) {
        mContext = context;
        mDatas = datas;
        mItemViewDelegateManager = new ItemViewDelegateManager();
    }

    @Override
    public int getItemViewType(int position) {
        if (!useItemViewDelegateManager()) return super.getItemViewType(position);
        return mItemViewDelegateManager.getItemViewType(getDatas().get(position), position);
    }


    @Override
    public SimplerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewDelegate itemViewDelegate = mItemViewDelegateManager.getItemViewDelegate(viewType);
        int layoutId = itemViewDelegate.getItemViewLayoutId();

        SimplerViewHolder holder = SimplerViewHolder.createViewHolder(mContext, parent, layoutId);
        onViewHolderCreated(holder,holder.getConvertView());
        setListener(parent, holder, viewType);
        return holder;
    }

    public void onViewHolderCreated(SimplerViewHolder holder,View itemView){

    }

    public void convert(SimplerViewHolder holder, T t) {
        mItemViewDelegateManager.convert(holder, t, holder.getAdapterPosition());
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }


    protected void setListener(final ViewGroup parent, final SimplerViewHolder viewHolder, int viewType) {
        if (!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    Toast.makeText(parent.getContext(),"点击点击点击",Toast.LENGTH_SHORT).show();
                    mOnItemClickListener.onItemClick(v, viewHolder , position ,mItemViewDelegateManager.getItemViewDelegate(getItemViewType(position)));
                }
            }
        });

        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    return mOnItemClickListener.onItemLongClick(v, viewHolder, position,mItemViewDelegateManager.getItemViewDelegate(getItemViewType(position)));
                }
                return false;
            }
        });
    }

    @Override
    public void onBindViewHolder(SimplerViewHolder holder, int position) {
        convert(holder, getDatas().get(position));
    }

    @Override
    public int getItemCount() {
        return getDatas().size();
    }


    public List<T> getDatas() {
        if (mDatas==null)
            return new ArrayList<>();
        return mDatas;
    }

    public void setDatas(List<T> mDatas){
        this.mDatas=mDatas;
        notifyDataSetChanged();
    }

    public MultiItemTypeAdapter addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        mItemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public MultiItemTypeAdapter addItemViewDelegate(int viewType, ItemViewDelegate<T> itemViewDelegate) {
        mItemViewDelegateManager.addDelegate(viewType, itemViewDelegate);
        return this;
    }

    protected boolean useItemViewDelegateManager() {
        return mItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position ,ItemViewDelegate itemViewDelegate);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position ,ItemViewDelegate ItemViewDelegate);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
