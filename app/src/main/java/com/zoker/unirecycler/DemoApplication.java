package com.zoker.unirecycler;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.zoker.unirecycler.GlideImageLoader.GlideImageLoader;
import com.zoker.unirecycler.Model.Model1;
import com.zoker.unirecycler.Model.Model2;
import com.zoker.unirecycler.viewHolder.MultiType_Model1_2;
import com.zoker.unirecycler.viewHolder.MultiType_Model2_2;

import me.drakeet.multitype.GlobalMultiTypePool;

/**
 * Created by Administrator on 2017/4/21.
 */

public class DemoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //MultiType库的全局添加Item
        GlobalMultiTypePool.register(Model1.class, new MultiType_Model1_2());
        GlobalMultiTypePool.register(Model2.class, new MultiType_Model2_2(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoApplication.this,"外层设置的listenr",Toast.LENGTH_SHORT).show();
            }
        }));

        Album.initialize(new AlbumConfig.Build()
                .setImageLoader(new GlideImageLoader()) // Use glide loader.
                .build());
    }
}
