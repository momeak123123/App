package com.example.hz52.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hz52.app.Entity.Message;
import com.example.hz52.app.Model.MessModel;
import com.example.hz52.app.cofig.Initialization;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Messages extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.imageView78)
    ImageView imageView78;
    @BindView(R.id.rect_view)
    RelativeLayout rectView;
    @BindView(R.id.imageView18)
    QMUIRadiusImageView imageView18;
    @BindView(R.id.textView66)
    TextView textView66;
    @BindView(R.id.textView67)
    TextView textView67;
    @BindView(R.id.imageView67)
    ImageView imageView67;
    @BindView(R.id.textView68)
    TextView textView68;
    @BindView(R.id.textView96)
    TextView textView96;
    @BindView(R.id.rect_views)
    RelativeLayout rectViews;
    @BindView(R.id.recycler10)
    RecyclerView recycler10;


    private ArrayList<Message> mArrayList;
    private ArrayList<Message> mArrayLists;
    private Observer<Integer> observer;
    private Context context;
    public static Observer<Integer> observermess;
    public static boolean isFront;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mess_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        context = getContext();
        Initialization.setupDatabaseConver(getContext());


        Window window = Objects.requireNonNull(getActivity()).getWindow();
        //21表示5.0
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(Color.WHITE);

        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体的颜色为黑色
        //ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
        decor.setSystemUiVisibility(ui);

        return view;

    }

    @Override
    public void onResume(){
        super.onResume();
        isFront = true;
        MessModel.initData(context);
        MessModel.initrecycler(context, getActivity(), recycler10, 0);
        //聊天
        observermess = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {


            }

            @Override
            public void onNext(Integer integer) {

                MessModel.initData(context);
                MessModel.initrecycler(context, getActivity(), recycler10, 0);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void onPause() {
        super.onPause();
        isFront = false;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static Messages newInstance() {
        Bundle args = new Bundle();
        Messages fragment = new Messages();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.imageView78, R.id.rect_views})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView78:
                Intent intent2 = new Intent(getContext(), mess_friends.class);
                startActivity(intent2);
                getActivity().overridePendingTransition(R.animator.anim_right_in, R.animator.anim_left_out);
                break;
            case R.id.rect_views:
                Intent intent3 = new Intent(getContext(), system_information.class);
                startActivity(intent3);
                getActivity().overridePendingTransition(R.animator.anim_right_in, R.animator.anim_left_out);
                break;
        }
    }
}