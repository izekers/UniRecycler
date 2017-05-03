package com.zoker.unirecycler.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.R;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_Model2_2 extends ItemViewProvider<Model2, MultiType_Model2_2.ViewHolder2> {
    public View.OnClickListener listener;

    public MultiType_Model2_2(View.OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    protected ViewHolder2 onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itmeView = inflater.inflate(R.layout.item_view2, parent, false);
        if (listener != null)
            itmeView.setOnClickListener(listener);
        return new ViewHolder2(itmeView);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder2 holder, @NonNull Model2 model) {
        holder.textView.setText(model.toString());
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder2(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tem2);
        }
    }
}
