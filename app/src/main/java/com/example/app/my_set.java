package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class my_set extends AppCompatActivity {

    @BindView(R.id.fold)
    ImageView fold;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.imageView119)
    ImageView imageView119;
    @BindView(R.id.textView137)
    TextView textView137;
    @BindView(R.id.imageView120)
    ImageView imageView120;
    @BindView(R.id.imageView121)
    ImageView imageView121;
    @BindView(R.id.textView138)
    TextView textView138;
    @BindView(R.id.imageView122)
    ImageView imageView122;
    @BindView(R.id.imageView123)
    ImageView imageView123;
    @BindView(R.id.textView139)
    TextView textView139;
    @BindView(R.id.imageView124)
    ImageView imageView124;
    @BindView(R.id.imageView125)
    ImageView imageView125;
    @BindView(R.id.textView140)
    TextView textView140;
    @BindView(R.id.imageView126)
    ImageView imageView126;
    @BindView(R.id.imageView127)
    ImageView imageView127;
    @BindView(R.id.textView141)
    TextView textView141;
    @BindView(R.id.imageView128)
    ImageView imageView128;
    @BindView(R.id.imageView129)
    ImageView imageView129;
    @BindView(R.id.textView142)
    TextView textView142;
    @BindView(R.id.imageView130)
    ImageView imageView130;
    @BindView(R.id.imageView131)
    ImageView imageView131;
    @BindView(R.id.textView143)
    TextView textView143;
    @BindView(R.id.imageView132)
    ImageView imageView132;
    @BindView(R.id.but)
    QMUIRoundButton but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fold, R.id.imageView119, R.id.textView137, R.id.imageView120, R.id.imageView121, R.id.textView138, R.id.imageView122, R.id.imageView123, R.id.textView139, R.id.imageView124, R.id.imageView125, R.id.textView140, R.id.imageView126, R.id.imageView127, R.id.textView141, R.id.imageView128, R.id.imageView129, R.id.textView142, R.id.imageView130, R.id.imageView131, R.id.textView143, R.id.imageView132, R.id.but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fold:
                this.finish();
                break;
            case R.id.imageView119:
            case R.id.textView137:
            case R.id.imageView120:
                Intent intent1 = new Intent(my_set.this, my_change_pass.class);
                startActivity(intent1);
                break;
            case R.id.imageView121:
            case R.id.textView138:
            case R.id.imageView122:
                Intent intent2 = new Intent(my_set.this, my_change_photo.class);
                intent2.putExtra("butnum",false);
                startActivity(intent2);
                break;
            case R.id.imageView123:
            case R.id.textView139:
            case R.id.imageView124:
                break;
            case R.id.imageView125:
            case R.id.textView140:
            case R.id.imageView126:
                break;
            case R.id.imageView127:
            case R.id.textView141:
            case R.id.imageView128:
                break;
            case R.id.imageView129:
            case R.id.textView142:
            case R.id.imageView130:
                break;
            case R.id.imageView131:
            case R.id.textView143:
            case R.id.imageView132:
                break;
            case R.id.but:
                break;
        }
    }
}