package com.zoker.unirecycler.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.R;

import me.drakeet.multitype.ItemViewProvider;

/**
 *
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_Model2 extends ItemViewProvider<Model2,MultiType_Model2.ViewHolder2> {

    @NonNull
    @Override
    protected ViewHolder2 onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder2(inflater.inflate(R.layout.item_view2,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder2 holder, @NonNull Model2 model) {
        holder.textView.setText(model.toString());
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView textView;
        ViewHolder2(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.tem2);
        }
    }
}
