package com.zoker.unirecycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import net.zoker.unirecycler.MultiItemTypeAdapter;
import net.zoker.unirecycler.base.ItemViewDelegate;
import net.zoker.unirecycler.base.SimplerViewHolder;
import net.zoker.unirecycler.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class HeaderFooterActivity extends Activity{
    List<Object> mdatas=new ArrayList<>();
    RecyclerView list;
    MultiItemTypeAdapter<Object> adater;
    HeaderAndFooterWrapper headerAndFooterWrapper;
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

        //万能适配器，多类型
        adater=new MultiItemTypeAdapter<>(this,mdatas);
        adater.addItemViewDelegate(new Item1Delete());
        adater.addItemViewDelegate(new Item2Delete());

        adater.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate itemViewDelegate) {
                if (itemViewDelegate instanceof Item1Delete){
                    Toast.makeText(HeaderFooterActivity.this,"点击了第一种按钮",Toast.LENGTH_SHORT).show();
                }else if (itemViewDelegate instanceof Item2Delete){
                    Toast.makeText(HeaderFooterActivity.this,"点击了第二种按钮",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate ItemViewDelegate) {
                return false;
            }
        });

        headerAndFooterWrapper=new HeaderAndFooterWrapper(adater);
        headerAndFooterWrapper.addHeaderView(headerOrFooterView());
        headerAndFooterWrapper.addHeaderView(headerOrFooterView());
        headerAndFooterWrapper.addFootView(headerOrFooterView());
        headerAndFooterWrapper.addFootView(headerOrFooterView());
        list.setAdapter(headerAndFooterWrapper);
    }


    public View headerOrFooterView(){
        return LayoutInflater.from(this).inflate(R.layout.header_footer_view,null);
    }

    class Item1Delete implements ItemViewDelegate<Object> {

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_view;
        }

        @Override
        public boolean isForViewType(Object item, int position) {
            int type=position%2==0?1:2;
            Log.e("MainActivity","position="+position+"type="+type);
            return position%2==0;
        }

        @Override
        public void convert(SimplerViewHolder holder, Object o, int position) {
            holder.setText(R.id.item_text_1,"这是第一种item");
        }
    }

    class Item2Delete implements ItemViewDelegate<Object>{

        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_view2;
        }

        @Override
        public boolean isForViewType(Object item, int position) {
            int type=position%2==0?1:2;
            Log.e("MainActivity","position="+position+"type="+type);
            return position%2!=0;
        }

        @Override
        public void convert(SimplerViewHolder holder, Object o, int position) {
            holder.setText(R.id.tem2,"这是第二种item");
        }
    }
}
