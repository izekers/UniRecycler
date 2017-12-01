package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zoker.unirecycler.bean.Demo1;
import com.zoker.unirecycler.bean.Demo2;
import com.zoker.unirecycler.bean.Demo3;
import com.zoker.unirecycler.viewholder.Demo1Viewholder;
import com.zoker.unirecycler.viewholder.Demo2Viewholder;
import com.zoker.unirecycler.viewholder.Demo3Viewholder;

import net.zoker.unirecycler.base.ListFragment;
import net.zoker.unirecycler.fragment.MultiTypeListFragment;
import net.zoker.unirecycler.fragment.MultiTypeListFragment2;

import java.util.Arrays;

import me.drakeet.multitype.ItemViewBinder;

public class MultiTypeListFragment2Activity extends AppCompatActivity {
    ListFragment<Object> mainFragment;
    private Object[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new Object[]{
                new Demo1(),
                new Demo1(),
                new Demo2(),
                new Demo1(),
                new Demo3(),
                new Demo1(),
                new Demo2()
        };
        getSupportFragmentManager().beginTransaction().add(R.id.root, mainFragment = new ListAdapterFragment()).commit();

        mainFragment.setData(Arrays.asList(datas));
    }

    public static class ListAdapterFragment extends MultiTypeListFragment2 {

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            switch (getItemViewType(position)) {
                case 1:
                    ((Demo1Viewholder) holder).setData((Demo1) getItemData(position));
                    break;
                case 2:
                    ((Demo2Viewholder) holder).setData((Demo2) getItemData(position));
                    break;
                case 3:
                    ((Demo3Viewholder) holder).setData((Demo3) getItemData(position));
                    break;
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case 1:
                    return new Demo1Viewholder(parent);
                case 2:
                    return new Demo2Viewholder(parent);
                case 3:
                    return new Demo3Viewholder(parent);
            }
            return null;
        }

        @Override
        public int getItemViewType(int position) {
            if (getItemData(position) instanceof Demo1) {
                return 1;
            } else if (getItemData(position) instanceof Demo2) {
                return 2;
            } else if (getItemData(position) instanceof Demo3) {
                return 3;
            } else
                return 0;
        }
    }
}
