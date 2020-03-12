package com.example.hz52.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hz52.app.Model.ListModel;
import com.google.gson.JsonArray;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class List extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.imageView86)
    ImageView imageView86;
    @BindView(R.id.imageView28)
    QMUIRadiusImageView imageView28;
    @BindView(R.id.imageView87)
    QMUIRadiusImageView imageView87;
    @BindView(R.id.imageView88)
    QMUIRadiusImageView imageView88;
    @BindView(R.id.imageView89)
    ImageView imageView89;
    @BindView(R.id.imageView90)
    ImageView imageView90;
    @BindView(R.id.imageView91)
    ImageView imageView91;
    @BindView(R.id.textView102)
    TextView textView102;
    @BindView(R.id.textView92)
    TextView textView92;
    @BindView(R.id.textView103)
    TextView textView103;
    @BindView(R.id.textView104)
    TextView textView104;
    @BindView(R.id.textView93)
    TextView textView93;
    @BindView(R.id.textView105)
    TextView textView105;
    @BindView(R.id.textView106)
    TextView textView106;
    @BindView(R.id.textView94)
    TextView textView94;
    @BindView(R.id.textView107)
    TextView textView107;
    @BindView(R.id.textView108)
    TextView textView108;
    @BindView(R.id.textView109)
    TextView textView109;
    @BindView(R.id.textView118)
    TextView textView118;
    @BindView(R.id.textView119)
    TextView textView119;
    @BindView(R.id.imageView18)
    QMUIRadiusImageView imageView18;
    @BindView(R.id.imageView19)
    QMUIRadiusImageView imageView19;
    @BindView(R.id.recyclers)
    RelativeLayout recyclers;
    @BindView(R.id.largeLabel2)
    RelativeLayout largeLabel2;
    @BindView(R.id.textView110)
    TextView textView110;
    @BindView(R.id.textView111)
    TextView textView111;
    @BindView(R.id.textView112)
    TextView textView112;
    @BindView(R.id.textView120)
    TextView textView120;
    @BindView(R.id.textView121)
    TextView textView121;
    @BindView(R.id.textView122)
    TextView textView122;
    @BindView(R.id.relative8)
    RelativeLayout relative8;
    @BindView(R.id.recycler13)
    RecyclerView recycler13;
    @BindView(R.id.textView67)
    TextView textView67;
    @BindView(R.id.imageView21)
    QMUIRadiusImageView imageView21;
    @BindView(R.id.textView66)
    TextView textView66;
    @BindView(R.id.textView68)
    TextView textView68;
    @BindView(R.id.textView113)
    TextView textView113;
    @BindView(R.id.textView114)
    TextView textView114;
    @BindView(R.id.relative10)
    RelativeLayout relative10;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private Context context;
    private int rankListCategory = 1;
    private int durationCategory = 1;
    public static Observer<JsonArray> observer;
    private Window window;
    private QMUITipDialog tipDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_leaderboard, container, false);
        unbinder = ButterKnife.bind(this, view);
        window = getActivity().getWindow();

        //21表示5.0
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.tabbarcolor));


        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        // ui |=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体的颜色为黑色
        ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; //设置状态栏中字体颜色为白色
        decor.setSystemUiVisibility(ui);


        context = getContext();
        tipDialog = new QMUITipDialog.Builder(getContext())
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
        ListModel.okgo(context, rankListCategory, durationCategory);
        ListModel.initrecycler(context, recycler13);

        textView108.setVisibility(View.GONE);
        textView109.setVisibility(View.VISIBLE);
        textView118.setVisibility(View.VISIBLE);
        textView119.setVisibility(View.GONE);
        imageView18.setVisibility(View.VISIBLE);
        textView110.setVisibility(View.VISIBLE);
        textView120.setVisibility(View.GONE);
        textView111.setVisibility(View.GONE);
        textView121.setVisibility(View.VISIBLE);
        textView112.setVisibility(View.VISIBLE);
        textView122.setVisibility(View.GONE);

        refreshLayout.setRefreshHeader(new MaterialHeader(getContext()).setScrollableWhenRefreshing(true));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshlayout) {
                refreshlayout.autoRefresh();
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                refreshlayout.finishRefresh();

            }
        });


        observer = new Observer<JsonArray>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JsonArray integer) {
                initData(integer);
                tipDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

       /* switch (position) {
            case 1:
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                        .setTipWord("发送成功")
                        .create();
                break;
            case 2:
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                        .setTipWord("发送失败")
                        .create();
                break;
            case 3:
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_INFO)
                        .setTipWord("请勿重复操作")
                        .create();
                break;
            case 4:
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                        .create();
                break;
            case 5:
                tipDialog = new QMUITipDialog.Builder(getContext())
                        .setTipWord("请勿重复操作")
                        .create();
                break;
            case 6:
                tipDialog = new QMUITipDialog.CustomBuilder(getContext())
                        .setContent(R.layout.tipdialog_custom)
                        .create();
                break;*/

        return view;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void initData(JsonArray jsonArray) {
        try {
            Long userid = Long.valueOf("923883237");
            if (rankListCategory == 1) {
                textView93.setText("财富值");
                textView92.setText("财富值");
                textView94.setText("财富值");
            } else if (rankListCategory == 2) {
                textView93.setText("魅力值");
                textView92.setText("魅力值");
                textView94.setText("魅力值");
            }
            for (int i = 0; i < jsonArray.size(); i++) {
                if (i == 0) {
                    Glide.with(this).load(jsonArray.get(i).getAsJsonObject().get("avatarUrl").getAsString()).into(imageView87);
                    textView104.setText(jsonArray.get(i).getAsJsonObject().get("nickname").getAsString());
                    textView105.setText(jsonArray.get(i).getAsJsonObject().get("count").getAsString());

                } else if (i == 1) {
                    Glide.with(this).load(jsonArray.get(i).getAsJsonObject().get("avatarUrl").getAsString()).into(imageView28);
                    textView102.setText(jsonArray.get(i).getAsJsonObject().get("nickname").getAsString());
                    textView103.setText(jsonArray.get(i).getAsJsonObject().get("count").getAsString());

                } else if (i == 2) {
                    Glide.with(this).load(jsonArray.get(i).getAsJsonObject().get("avatarUrl").getAsString()).into(imageView88);
                    textView106.setText(jsonArray.get(i).getAsJsonObject().get("nickname").getAsString());
                    textView107.setText(jsonArray.get(i).getAsJsonObject().get("count").getAsString());

                }

                if (jsonArray.get(i).getAsJsonObject().get("uniqueId").getAsLong() == userid) {
                    textView67.setText(i + 1 + "");
                    Glide.with(this).load(jsonArray.get(i).getAsJsonObject().get("avatarUrl").getAsString()).into(imageView21);
                    textView66.setText(jsonArray.get(i).getAsJsonObject().get("nickname").getAsString());
                    textView68.setText(jsonArray.get(i).getAsJsonObject().get("count").getAsString());
                    if (i == 0) {
                        textView113.setText(0 + "");
                    } else {
                        Long lon = jsonArray.get(i - 1).getAsJsonObject().get("count").getAsLong() - jsonArray.get(i).getAsJsonObject().get("count").getAsLong();
                        textView113.setText(lon + "");
                    }

                }

            }
        }catch (Exception e){

        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里接收到广播和数据，进行处理就是了

    }


    public static List newInstance() {
        Bundle args = new Bundle();
        List fragment = new List();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.textView108, R.id.textView109, R.id.textView118, R.id.textView119, R.id.textView110, R.id.textView111, R.id.textView112, R.id.textView120, R.id.textView121, R.id.textView122})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView108:
                rankListCategory = 1;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                textView108.setVisibility(View.GONE);
                textView109.setVisibility(View.VISIBLE);
                textView118.setVisibility(View.VISIBLE);
                textView119.setVisibility(View.GONE);
                imageView18.setVisibility(View.VISIBLE);
                break;
            case R.id.textView109:
                rankListCategory = 2;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                textView108.setVisibility(View.VISIBLE);
                textView109.setVisibility(View.GONE);
                textView118.setVisibility(View.GONE);
                textView119.setVisibility(View.VISIBLE);
                imageView19.setVisibility(View.VISIBLE);
                break;
            case R.id.textView118:
                rankListCategory = 1;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                break;
            case R.id.textView119:
                rankListCategory = 2;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                break;
            case R.id.textView110:
                durationCategory = 1;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                textView110.setVisibility(View.GONE);
                textView120.setVisibility(View.VISIBLE);
                textView111.setVisibility(View.VISIBLE);
                textView121.setVisibility(View.GONE);
                textView112.setVisibility(View.VISIBLE);
                textView122.setVisibility(View.GONE);
                break;
            case R.id.textView111:
                durationCategory = 2;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                textView110.setVisibility(View.VISIBLE);
                textView120.setVisibility(View.GONE);
                textView111.setVisibility(View.GONE);
                textView121.setVisibility(View.VISIBLE);
                textView112.setVisibility(View.VISIBLE);
                textView122.setVisibility(View.GONE);
                break;
            case R.id.textView112:
                durationCategory = 3;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                textView110.setVisibility(View.VISIBLE);
                textView120.setVisibility(View.GONE);
                textView111.setVisibility(View.VISIBLE);
                textView121.setVisibility(View.GONE);
                textView112.setVisibility(View.GONE);
                textView122.setVisibility(View.VISIBLE);
                break;
            case R.id.textView120:
                durationCategory = 1;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                break;
            case R.id.textView121:
                durationCategory = 2;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                break;
            case R.id.textView122:
                durationCategory = 3;
                ListModel.okgo(context, rankListCategory, durationCategory);
                ListModel.initrecycler(context, recycler13);
                break;
        }
    }
}