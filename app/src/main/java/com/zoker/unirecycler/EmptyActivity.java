package com.zoker.unirecycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.zoker.unirecycler.CommonAdapter;
import net.zoker.unirecycler.base.SimplerViewHolder;
import net.zoker.unirecycler.wrapper.EmptyWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class EmptyActivity extends Activity{
    List<Object> mdatas=new ArrayList<>();
    RecyclerView list;
    CommonAdapter<Object> commonAdapter;
    EmptyWrapper emptyWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul);

        //zhy方案
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        list=(RecyclerView)findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        //万能适配器，单类型
        commonAdapter=new CommonAdapter<Object>(this,R.layout.item_view,mdatas) {
            @Override
            protected void convert(SimplerViewHolder holder, Object o, int position) {
                holder.setText(R.id.item_text_1,"这是单按钮");
            }
        };
        emptyWrapper=new EmptyWrapper(commonAdapter);
        list.setAdapter(emptyWrapper);
    }
}
