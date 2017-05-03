package com.zoker.unirecycler;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yanzhenjie.album.Album;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/21.
 */

public class PhotoActivity extends AppCompatActivity{
    private static final int requestCode2 = 862;
    ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        findViewById(R.id.photo)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        photo(requestCode2);
                    }
                });
        findViewById(R.id.ca)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        takePic(requestCode2);
                    }
                });
        img=(ImageView) findViewById(R.id.image);
    }


    public void takePic(int requestCode){
        Album.camera(this)
                .requestCode(requestCode)
                // .imagePath() // 指定相机拍照的路径，建议非特殊情况不要指定.
                .start();
    }

    public void photo(int requestCode){
        Album.album(this)
                .requestCode(requestCode) // 请求码，返回时onActivityResult()的第一个参数。
//                .toolBarColor(toolbarColor) // Toolbar 颜色，默认蓝色。
//                .statusBarColor(statusBarColor) // StatusBar 颜色，默认蓝色。
//                .navigationBarColor(navigationBarColor) // NavigationBar 颜色，默认黑色，建议使用默认。
                .title("图库") // 配置title。
                .selectCount(1)
//                .selectCount(9) // 最多选择几张图片。
                .columnCount(4) // 相册展示列数，默认是2列。
                .camera(true) // 是否有拍照功能。
//                .checkedList(mImageList) // 已经选择过得图片，相册会自动选中选过的图片，并计数。
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == requestCode2) {
            if (resultCode == RESULT_OK) { // Successfully.
                // 不要质疑你的眼睛，就是这么简单。
                ArrayList<String> pathList = Album.parseResult(data);
                Glide.with(this)
                        .load(pathList.get(0))
                        .into(img);
            } else if (resultCode == RESULT_CANCELED) { // User canceled.
                // 用户取消了操作。
            }
        }
    }
}
