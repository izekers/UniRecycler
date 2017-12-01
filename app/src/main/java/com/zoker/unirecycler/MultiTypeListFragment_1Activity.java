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
import com.zoker.unirecycler.viewholder.Demo4Viewholder;

import net.zoker.unirecycler.base.ListFragment;
import net.zoker.unirecycler.fragment.MultiTypeListFragment;

import java.util.Arrays;

import me.drakeet.multitype.ClassLinker;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.Linker;

public class MultiTypeListFragment_1Activity extends AppCompatActivity {
    ListFragment<Object> mainFragment;
    private Object[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new Object[]{
                new Demo1(),
                new Demo1(4),
                new Demo1(),
                new Demo2(),
                new Demo3(),
                new Demo2(),
                new Demo1(4),
                new Demo1(4)
        };
        getSupportFragmentManager().beginTransaction().add(R.id.root, mainFragment = new ListAdapterFragment()).commit();

        mainFragment.setData(Arrays.asList(datas));
    }

    public static class ListAdapterFragment extends MultiTypeListFragment {

        @Override
        public void installType() {
            register(Demo1.class).to(new ItemViewBinder<Demo1, Demo1Viewholder>() {
                @NonNull
                @Override
                protected Demo1Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
                    return new Demo1Viewholder(parent);
                }

                @Override
                protected void onBindViewHolder(@NonNull Demo1Viewholder holder, @NonNull Demo1 item) {
                    holder.setData(item);
                }
            },new ItemViewBinder<Demo1, Demo4Viewholder>() {
                @NonNull
                @Override
                protected Demo4Viewholder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
                    return new Demo4Viewholder(parent);
                }

                @Override
                protected void onBindViewHolder(@NonNull Demo4Viewholder holder, @NonNull Demo1 item) {
                    holder.setData(item);
                }
            }).withLinker(new Linker<Demo1>() {
                @Override
                public int index(int position, @NonNull Demo1 demo1) {
                    if (demo1.getType() == 4) {
                        return 1;
                    }else
                        return 0;
                }
            });
        }
    }
}
