package com.zoker.unirecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import net.zoker.unirecycler.base.SimplerViewHolder;
import net.zoker.unirecycler.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    HeaderAndFooterWrapper recyclerAdapter;
    View view;
    Adater adater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new GridLayoutManager(this,5));
        adater=new Adater();
        adater.setData(mdatas);
        recyclerAdapter=new HeaderAndFooterWrapper<>(adater);
        recyclerAdapter.addHeaderView(headerOrFooterView());
        recyclerAdapter.addHeaderView(headerOrFooterView());
        recyclerAdapter.addFootView(headerOrFooterView());
        recyclerAdapter.addFootView(headerOrFooterView());
        recycler_view.setAdapter(recyclerAdapter);

        findViewById(R.id.grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdatas.add(new Object());
                mdatas.add(new Object());
                adater.setData(mdatas);
                recyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    public View headerOrFooterView(){
        return LayoutInflater.from(this).inflate(R.layout.header_view,null);
    }
    private List<Object> mdatas=new ArrayList<>();

    class Adater extends RecyclerView.Adapter{
        List<Object> data=new ArrayList<>();
        private void setData(List<Object> mdata){
            this.data=mdata;
            notifyDataSetChanged();
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return SimplerViewHolder.createViewHolder
                    (parent.getContext(),
                            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
