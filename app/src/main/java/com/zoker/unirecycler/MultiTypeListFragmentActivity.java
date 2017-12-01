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
import net.zoker.unirecycler.fragment.UniSingleListFragment;

import java.util.Arrays;

import me.drakeet.multitype.ItemViewBinder;

public class MultiTypeListFragmentActivity extends AppCompatActivity {
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

    public static class ListAdapterFragment extends MultiTypeListFragment {

        @Override
        public void installType() {
            register(Demo1.class, new ItemViewBinder<Demo1, Demo1Viewholder>() {
                @NonNull
                @Override
                protected Demo1Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
                    return new Demo1Viewholder(parent);
                }

                @Override
                protected void onBindViewHolder(@NonNull Demo1Viewholder holder, @NonNull Demo1 item) {
                    holder.setData(item);
                }
            });


            register(Demo2.class, new ItemViewBinder<Demo2, Demo2Viewholder>() {
                @NonNull
                @Override
                protected Demo2Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
                    return new Demo2Viewholder(parent);
                }

                @Override
                protected void onBindViewHolder(@NonNull Demo2Viewholder holder, @NonNull Demo2 item) {
                    holder.setData(item);
                }
            });


            register(Demo3.class, new ItemViewBinder<Demo3, Demo3Viewholder>() {
                @NonNull
                @Override
                protected Demo3Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
                    return new Demo3Viewholder(parent);
                }

                @Override
                protected void onBindViewHolder(@NonNull Demo3Viewholder holder, @NonNull Demo3 item) {
                    holder.setData(item);
                }
            });
        }
    }
}
