package com.example.app.Model;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Adapter.GiftheadAdapter;
import com.example.app.Adapter.RoomheadchatAdapter;
import com.example.app.Entity.Gifthead;
import com.example.app.Entity.Roomheadchat;
import com.example.app.Entity.Roomtxt;

import java.util.ArrayList;

public class GiftheadModel {

    private static ArrayList<Gifthead> mData;
    private static GiftheadAdapter mAdapters;

    public static void initData() {

        mData = new ArrayList<Gifthead>();

        for(int i=0;i<10;i++){
            Gifthead i1 = new Gifthead("https://momeak.oss-cn-shenzhen.aliyuncs.com/h2.jpg","");
            mData.add(i1);
        }

    }

    public static void initrecyclers(Context context, RecyclerView gridview) {
         mAdapters = new GiftheadAdapter(context, mData);
        //设置适配器adapter
        gridview.setAdapter(mAdapters);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        gridview.setLayoutManager(layoutManager);

        gridview.setItemAnimator(new DefaultItemAnimator());

        mAdapters.setOnItemClickListener(new GiftheadAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, position + " click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context, position + " Long click", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 既然是动画，就会有时间，我们把动画执行时间变大一点来看一看效果
         */
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(200);
        defaultItemAnimator.setRemoveDuration(200);
        gridview.setItemAnimator(defaultItemAnimator);


    }

    public static void Add(RecyclerView mRecyclerView, Gifthead entity){
        mAdapters.addData(mData.size(), entity);
        mRecyclerView.smoothScrollToPosition(mData.size());
    }
}
