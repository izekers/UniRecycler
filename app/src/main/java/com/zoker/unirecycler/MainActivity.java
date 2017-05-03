package com.zoker.unirecycler;

import android.content.Intent;
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
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    HeaderAndFooterWrapper wrapper;
    MultiItemTypeAdapter adater;
    CommonAdapter commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final IntentModel[] mdata=new IntentModel[]{
                new IntentModel("zhy:单适配器",new Intent(this,ZhyActivity.class)),
                new IntentModel("zhy:多适配器",new Intent(this,zhyMulActivity.class)),
                new IntentModel("zhy:空数据适配器",new Intent(this,EmptyActivity.class)),
                new IntentModel("zhy:Header_footer数据适配器",new Intent(this,HeaderFooterActivity.class)),
                new IntentModel("zhy:加载更多适配器",new Intent(this,LoadMoreActivity.class)),
                new IntentModel("MultiType:最简单的使用方式",new Intent(this,MultiType_singleItemActivity.class)),
                new IntentModel("MultiType:全局注册item的使用方式",new Intent(this,MultiType_globalItemActivity.class)),
                new IntentModel("MultiType:二级item的使用方式",new Intent(this,MultiType_secondaryItemActivity.class)),
                new IntentModel("测试照相库",new Intent(this,PhotoActivity.class)),
        };

        recycler_view=(RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        commonAdapter=new CommonAdapter<IntentModel>(this,R.layout.main_item,Arrays.asList(mdata)) {
            @Override
            protected void convert(SimplerViewHolder holder, IntentModel intentModel, int position) {
                holder.setText(R.id.item_view,intentModel.getName());
            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate itemViewDelegate) {
                startActivity(mdata[position].getIntent());
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position, ItemViewDelegate ItemViewDelegate) {
                return false;
            }
        });

        recycler_view.setAdapter(commonAdapter);
    }
}
