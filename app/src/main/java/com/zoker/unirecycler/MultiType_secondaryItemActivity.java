package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zoker.unirecycler.Model.FlattenModel;
import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.viewHolder.MultiType_Model1;
import com.zoker.unirecycler.viewHolder.MultiType_Model2;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 这里是调用MultiType库的二级分发的实现方法，主要是集成MultiTypeAdapter，并重写onFlattenClass方法
 * Created by Administrator on 2017/4/21.
 */
public class MultiType_secondaryItemActivity extends AppCompatActivity{
    private MultiTypeAdapter adapter;
    //Items 等价于 ArrayList<Object>
    private List<FlattenModel> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        items=new ArrayList<>();
        adapter=new SecondaryAdapter(items);

        setdata();

        recycler_view.setAdapter(adapter);
    }

    //二级分发的adapter
    public class SecondaryAdapter extends MultiTypeAdapter {

         SecondaryAdapter(List<FlattenModel> flattenModels) {
            super(flattenModels);
        }

        //这里筛选出适配的Model类型
        @NonNull
        @Override
        public Class onFlattenClass(@NonNull Object item) {
            return ((FlattenModel)item).getModel().getClass();
        }
    }

    public void setdata(){
        for (int i = 0; i < 20; i++) {
            items.add(new FlattenModel(new Model1("第一个item")));
            items.add(new FlattenModel(new Model2("第一个item")));
            items.add(new FlattenModel(new Model2("第二个item")));
        }
    }
}
