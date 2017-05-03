package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.zoker.unirecycler.CommonAdapter;
import net.zoker.unirecycler.MultiItemTypeAdapter;
import net.zoker.unirecycler.base.SimplerViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class ZhyActivity extends AppCompatActivity{
    List<Object> mdatas=new ArrayList<>();
    List<Object> mdatas2=new ArrayList<>();
    RecyclerView list;
    CommonAdapter<Object> commonAdapter;
    View btn_update;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
        list.setAdapter(commonAdapter);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                mdatas2.add(new Object());
                DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(new DiffUtil.Callback() {
                    @Override
                    public int getOldListSize() {
                        return mdatas.size();
                    }

                    @Override
                    public int getNewListSize() {
                        return mdatas2.size();
                    }

                    @Override
                    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                        return !mdatas.get(oldItemPosition).equals(mdatas2.get(newItemPosition));
                    }

                    @Override
                    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                        return true;
                    }
                },true);
                diffResult.dispatchUpdatesTo(commonAdapter);
            }
        });
    }
}
