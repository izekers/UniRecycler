package com.zoker.unirecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.zoker.unirecycler.bean.Demo1;
import com.zoker.unirecycler.viewholder.Demo1Viewholder;

import net.zoker.unirecycler.base.ListFragment;
import net.zoker.unirecycler.fragment.SingleListFragment;
import net.zoker.unirecycler.fragment.UniSingleListFragment;

import java.util.Arrays;

public class UniSingleListFragmentActivity extends AppCompatActivity {
    ListFragment<Demo1> mainFragment;
    private Demo1[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas = new Demo1[]{
                new Demo1(),
                new Demo1(),
                new Demo1(),
                new Demo1(),
                new Demo1(),
                new Demo1(),
                new Demo1()
        };
        getSupportFragmentManager().beginTransaction().add(R.id.root, mainFragment = new SingleListAdapterFragment()).commit();

        mainFragment.setData(Arrays.asList(datas));
    }

    public static class SingleListAdapterFragment extends UniSingleListFragment<Demo1, Demo1Viewholder> {

        @Override
        public Demo1Viewholder onCreateViewHolder(ViewGroup parent) {
            return new Demo1Viewholder(parent);
        }
    }
}
