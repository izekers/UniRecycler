package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.viewHolder.MultiType_Model1;
import com.zoker.unirecycler.viewHolder.MultiType_Model2;

import net.zoker.unirecycler.MultiItemTypeAdapter;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 这里是调用MultiType库的最基础用法
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_singleItemActivity extends AppCompatActivity{
    private MultiTypeAdapter adapter;
    //Items 等价于 ArrayList<Object>
    private Items items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        items=new Items();
        adapter=new MultiTypeAdapter(items);

        /* 注册类型和View的对应关系 */
        adapter.register(Model1.class,new MultiType_Model1());
        adapter.register(Model2.class,new MultiType_Model2());

        setdata();

        recycler_view.setAdapter(adapter);
    }

    public void setdata(){
        for (int i = 0; i < 20; i++) {
            items.add(new Model1("第一个item"));
            items.add(new Model2("第一个item"));
            items.add(new Model2("第二个item"));
        }
    }
}
