package com.zoker.unirecycler.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoker.unirecycler.bean.Demo1;
import com.zoker.unirecycler.bean.Demo3;

import net.zoker.unirecycler.base.UniViewHolder;

/**
 * Created by zoker on 2017/11/30.
 */

public class Demo3Viewholder extends UniViewHolder<Demo3> {

    public static View createView(ViewGroup parent) {
        TextView textView = new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return textView;
    }

    public Demo3Viewholder(ViewGroup parent) {
        this(createView(parent));
    }

    public Demo3Viewholder(ViewGroup parent, int layoutRes) {
        super(parent, layoutRes);
    }

    public Demo3Viewholder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Demo3 demo) {
        ((TextView)itemView).setText(demo.title);
    }
}
