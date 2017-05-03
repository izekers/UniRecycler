package com.zoker.unirecycler.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.R;

import me.drakeet.multitype.ItemViewProvider;

/**
 *
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_Model1 extends ItemViewProvider<Model1,MultiType_Model1.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_view,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Model1 model1) {
        holder.textView.setText(model1.toString());
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.item_text_1);
        }
    }
}
