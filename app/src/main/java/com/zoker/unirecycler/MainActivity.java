package com.zoker.unirecycler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoker.unirecycler.bean.Demo1;
import com.zoker.unirecycler.bean.ModelBean;
import com.zoker.unirecycler.viewholder.Demo1Viewholder;
import com.zoker.unirecycler.viewholder.MainViewHolder;

import net.zoker.unirecycler.base.UniItemViewBinder;
import net.zoker.unirecycler.base.ListFragment;
import net.zoker.unirecycler.fragment.MultiTypeListFragment;
import net.zoker.unirecycler.fragment.MultiTypeListFragment2;
import net.zoker.unirecycler.fragment.SingleListFragment;
import net.zoker.unirecycler.fragment.UniSingleListFragment;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
     ListFragment<ModelBean> mainFragment;
    private ModelBean[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new ModelBean[]{
                new ModelBean("单类型ListFragment", this, SingleListFragmentActivity.class),
                new ModelBean("单类型ListFragment,需要继承UniViewHolder", this, UniSingleListFragmentActivity.class),
                new ModelBean("多类型ListFragment", this, MultiTypeListFragmentActivity.class),
                new ModelBean("多类型ListFragment2", this, MultiTypeListFragment2Activity.class),
                new ModelBean("多类型ListFragment_单类型数据多类型应用", this, MultiTypeListFragment_1Activity.class),
        };
        getSupportFragmentManager().beginTransaction().add(R.id.root, mainFragment = new MainFragment()).commit();

        mainFragment.setData(Arrays.asList(datas));
    }

    public static class MainFragment extends SingleListFragment<ModelBean,MainViewHolder>{

        @Override
        public void onBindViewHolder(final MainViewHolder holder, int position) {
            holder.nameView.setText(getItemData(position).getTitle());
            holder.nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(getItemData(holder.getAdapterPosition()).getIntent());
                }
            });
        }

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent) {
            return  new MainViewHolder(parent);
        }
    }
}
