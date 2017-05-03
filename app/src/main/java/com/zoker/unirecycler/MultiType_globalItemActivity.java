package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.viewHolder.MultiType_Model1;
import com.zoker.unirecycler.viewHolder.MultiType_Model2;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 在Application注册全局item然后调用到局部adapter中
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_globalItemActivity extends AppCompatActivity{
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

        //将全局的类型加入到局部适配器来
        //全局的添加在Application中实现了，当然其他地方也能实现
        adapter.applyGlobalMultiTypePool();

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
