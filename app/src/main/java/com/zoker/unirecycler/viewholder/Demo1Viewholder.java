package com.zoker.unirecycler.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoker.unirecycler.bean.Demo1;

import net.zoker.unirecycler.base.UniViewHolder;

/**
 * Created by zoker on 2017/11/30.
 */

public class Demo1Viewholder extends UniViewHolder<Demo1> {

    public static View createView(ViewGroup parent) {
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return textView;
    }

    public Demo1Viewholder(ViewGroup parent) {
        this(createView(parent));
    }

    public Demo1Viewholder(ViewGroup parent, int layoutRes) {
        super(parent, layoutRes);
    }

    public Demo1Viewholder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Demo1 demo) {

        ((TextView)itemView).setText(demo.title);
    }
}
