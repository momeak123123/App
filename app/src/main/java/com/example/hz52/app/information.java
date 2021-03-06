package com.example.hz52.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bruce.pickerview.popwindow.DatePickerPopWin;
import com.example.hz52.app.Entity.MyApp;
import com.example.hz52.app.cofig.DateUtil;
import com.example.hz52.app.cofig.Initialization;
import com.example.hz52.app.cofig.Preview;
import com.example.hz52.app.gen.DaoSession;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class information extends AppCompatActivity {


    private static DaoSession daoSession;
    @BindView(R.id.imageView2)
    QMUIRadiusImageView imageView2;
    @BindView(R.id.imageView19)
    QMUIRadiusImageView imageView19;
    @BindView(R.id.imageView138)
    QMUIRadiusImageView imageView138;
    @BindView(R.id.imageView139)
    QMUIRadiusImageView imageView139;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.but)
    QMUIRoundButton but;
    @BindView(R.id.textView156)
    TextView textView156;
    @BindView(R.id.textView161)
    TextView textView161;
    @BindView(R.id.textView162)
    TextView textView162;
    @BindView(R.id.radioButton2)
    RadioButton radioButton2;
    @BindView(R.id.radioButton3)
    RadioButton radioButton3;
    @BindView(R.id.textView163)
    TextView textView163;
    @BindView(R.id.textView164)
    TextView textView164;
    @BindView(R.id.imageView140)
    ImageView imageView140;
    private int sex = 2;
    private String phone;
    private String pass;
    private String picturePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        ButterKnife.bind(this);
        Initialization.setupDatabaseUser(this);
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        pass = intent.getStringExtra("pass");
        editText.setText("");
    }


    private void data() {
        DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(information.this, new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                textView164.setText(dateDesc);
            }
        }).textConfirm("确定") //text of confirm button
                .textCancel("取消") //text of cancel button
                .btnTextSize(16) // button text size
                .viewTextSize(25) // pick view text size
                .colorCancel(Color.parseColor("#999999")) //color of cancel button
                .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                .minYear(1990) //min year in loop
                .maxYear(2550) // max year in loop
                .dateChose("2000-01-01") // date chose when init popwindow
                .build();
        pickerPopWin.showPopWin(information.this);
    }


    @OnClick({R.id.imageView139, R.id.but, R.id.radioButton2, R.id.radioButton3, R.id.textView164, R.id.imageView140, R.id.imageView2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but:
                if (!editText.getText().toString().equals("")) {
                    okgo();
                } else {
                    Toast.makeText(information.this, "请输入昵称", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radioButton2:
                radioButton2.setChecked(true);
                radioButton3.setChecked(false);
                sex = 2;
                break;
            case R.id.radioButton3:
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                sex = 1;
                break;
            case R.id.imageView139:
            case R.id.textView164:
            case R.id.imageView140:
                data();
                break;
            case R.id.imageView2:
               /* PictureSelector
                        .create(information.this, PictureSelector.SELECT_REQUEST_CODE)
                        .selectPicture(true, 400, 400, 1, 1);*/
                break;
        }
    }


    private void okgo() {
        MyApp application = ((MyApp) this.getApplicationContext());

        String date = null;
        try {
            date = DateUtil.dateToStamps(textView164.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String finalDate = date;
        OkGo.<String>post(application.getUrl() + "/app/user/register")
                .params("phone", phone)
                .params("password", pass)
                .params("nickname", editText.getText().toString())
                .params("gender", sex)
                .params("birthday", finalDate)
                .params("avatarUrl", "https://momeak.oss-cn-shenzhen.aliyuncs.com/h1.jpg")
                .execute(new StringCallback() {

                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {

                        Gson gson = new Gson();
                        Preview prexiew = gson.fromJson(response.body(), Preview.class);

                        if (prexiew.getCode() == 0) {
                            Toast.makeText(information.this, prexiew.getMsg() + "", Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(information.this, login.class);
                            startActivity(intent2);
                            
                        } else if (prexiew.getCode() == 40000) {
                            Toast.makeText(information.this, prexiew.getMsg() + "", Toast.LENGTH_SHORT).show();
                        } else if (prexiew.getCode() == 40004) {
                            Toast.makeText(information.this, prexiew.getMsg() + "", Toast.LENGTH_SHORT).show();
                            Intent intent2 = new Intent(information.this, registered.class);
                            startActivity(intent2);
                            
                        }


                    }


                });

    }

}
