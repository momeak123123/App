package com.example.hz52.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hz52.app.Entity.MyApp;
import com.example.hz52.app.cofig.Preview;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class my_wallet extends AppCompatActivity {

    @BindView(R.id.fold)
    ImageView fold;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.imageView17)
    QMUIRadiusImageView imageView17;
    @BindView(R.id.imageView59)
    ImageView imageView59;
    @BindView(R.id.textView51)
    TextView textView51;
    @BindView(R.id.imageView35)
    QMUIRadiusImageView imageView35;
    @BindView(R.id.textView10)
    TextView textView10;
    @BindView(R.id.textView53)
    TextView textView53;
    @BindView(R.id.textView54)
    TextView textView54;
    @BindView(R.id.imageView18)
    QMUIRadiusImageView imageView18;
    @BindView(R.id.imageView60)
    ImageView imageView60;
    @BindView(R.id.textView52)
    TextView textView52;
    @BindView(R.id.imageView36)
    QMUIRadiusImageView imageView36;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.textView55)
    TextView textView55;
    @BindView(R.id.textView56)
    TextView textView56;
    @BindView(R.id.imageView19)
    QMUIRadiusImageView imageView19;
    @BindView(R.id.imageView61)
    ImageView imageView61;
    @BindView(R.id.textView58)
    TextView textView58;
    @BindView(R.id.textView59)
    TextView textView59;
    @BindView(R.id.textView60)
    TextView textView60;
    private String gold;
    private String diamond;
    private String packageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
        title.setText("我的钱包");
        subtitle.setText("账单");


    }

    @Override
    protected void onResume() {
        super.onResume();
        okgo();
    }

    private void okgo() {
        MyApp application = ((MyApp) this.getApplicationContext());
        SharedPreferences sp = getSharedPreferences("User", Context.MODE_PRIVATE);
        String userid = sp.getString("userid","");
        String token = sp.getString("token","");
        OkGo.<String>post(application.getUrl()+"/app/user/getWallet?token="+token)
                .params("userId",userid)
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        Gson gson = new Gson();
                        Preview prexiew = gson.fromJson(response.body(), Preview.class);

                        if(prexiew.getCode()==0){
                             gold = prexiew.getData().get("gold").getAsString();
                             diamond = prexiew.getData().get("diamond").getAsString();
                            String amount = prexiew.getData().get("amount").getAsString();

                            textView53.setText(gold);
                            textView55.setText(diamond);
                            textView59.setText(amount);

                        }else {
                            Toast.makeText(my_wallet.this, prexiew.getMsg()+"", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @OnClick({R.id.fold, R.id.subtitle, R.id.imageView35, R.id.textView10, R.id.imageView36, R.id.textView11, R.id.imageView17, R.id.imageView18, R.id.imageView19})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fold:
                this.finish();
                break;
            case R.id.subtitle:
                Intent intent = new Intent(my_wallet.this, operation_record.class);
                startActivity(intent);
                
                break;
            case R.id.imageView35:
            case R.id.textView10:
                Intent intent1 = new Intent(my_wallet.this, my_gold.class);
                startActivity(intent1);
                
                break;
            case R.id.imageView36:
            case R.id.textView11:
                Intent intent2 = new Intent(my_wallet.this, withdraw.class);
                startActivity(intent2);
                
                break;
            case R.id.imageView17:
                Intent intent3 = new Intent(my_wallet.this, my_gold.class);
                intent3.putExtra("gold",gold);
                startActivity(intent3);
                
                break;
            case R.id.imageView18:
                Intent intent4 = new Intent(my_wallet.this, my_diamond.class);
                intent4.putExtra("diamond",diamond);
                startActivity(intent4);
                
                break;
            case R.id.imageView19:
                Intent intent5 = new Intent(my_wallet.this, my_package.class);
                startActivity(intent5);
                
                break;
        }
    }



    @Override
    public void onBackPressed() {
        this.finish();
    }
}
