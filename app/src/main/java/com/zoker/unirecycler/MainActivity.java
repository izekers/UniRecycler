package com.zoker.unirecycler;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import net.zoker.unirecycler.CommonAdapter;
import net.zoker.unirecycler.MultiItemTypeAdapter;
import net.zoker.unirecycler.base.ItemViewDelegate;
import net.zoker.unirecycler.base.SimplerViewHolder;
import net.zoker.unirecycler.wrapper.EmptyWrapper;
import net.zoker.unirecycler.wrapper.HeaderAndFooterWrapper;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    HeaderAndFooterWrapper wrapper;
    MultiItemTypeAdapter adater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //zhy方案
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        mdatas.add(new Object());
        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        //万能适配器，多类型
        adater=new MultiItemTypeAdapter(this,mdatas);
        adater.addItemViewDelegate(new Item1Delete());
        adater.addItemViewDelegate(new Item2Delete());
        adater.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate itemViewDelegate) {

                if (itemViewDelegate instanceof Item1Delete){
                    Toast.makeText(MainActivity.this,"点击了第一种按钮",Toast.LENGTH_SHORT).show();
                }else if (itemViewDelegate instanceof Item2Delete){
                    Toast.makeText(MainActivity.this,"点击了第二种按钮",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate ItemViewDelegate) {
                return false;
            }
        });
        recycler_view.setAdapter(adater);


        //万能适配器，单类型
        final CommonAdapter<Object> commonAdapter=new CommonAdapter<Object>(this,R.layout.item_view,mdatas) {
            @Override
            protected void convert(SimplerViewHolder holder, Object o, int position) {
                holder.setText(R.id.item_text_1,"这是单按钮");
            }
        };
        recycler_view.setAdapter(commonAdapter);

        //空数据适配器
        final EmptyWrapper emptyWrapper=new EmptyWrapper(commonAdapter);
        emptyWrapper.setEmptyView(R.layout.empty_view);
        recycler_view.setAdapter(emptyWrapper);

        //添加头部适配
        wrapper=new HeaderAndFooterWrapper(emptyWrapper);
        wrapper.addHeaderView(headerOrFooterView());
        wrapper.addHeaderView(headerOrFooterView());
        wrapper.addFootView(headerOrFooterView());
        wrapper.addFootView(headerOrFooterView());
        recycler_view.setAdapter(wrapper);

        findViewById(R.id.grid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mdatas.add(new Object());
//                mdatas.add(new Object());
//                adater.setDatas(mdatas);
                commonAdapter.setDatas(null);
                wrapper.notifyDataSetChanged();
            }
        });
    }

    public View headerOrFooterView(){
        return LayoutInflater.from(this).inflate(R.layout.header_footer_view,null);
    }
    private List<Object> mdatas=new ArrayList<>();

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
