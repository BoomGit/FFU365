package com.boom.ffu365;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Boom on 2017/6/28.
 */
public class UserLoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox check_password_cb;
    EditText user_phone_et,user_password_et;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        check_password_cb = (CheckBox) findViewById(R.id.check_password_cb);
        user_phone_et = (EditText) findViewById(R.id.user_phone_et);
        user_password_et = (EditText) findViewById(R.id.user_password_et);
        //1.完成基本功能  显示和隐藏密码
        //监听checkBox的状态改变
        check_password_cb.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //CompoundButton  代表当前的 CheckBox  isChecked 代表当前是否选中
        if (isChecked){
            //显示密码
            user_password_et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            //隐藏密码
            user_password_et.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

        //把光标移到最后
        Editable phone = user_phone_et.getText();
        Selection.setSelection(phone,phone.length());
        Editable password = user_password_et.getText();
        Selection.setSelection(password,password.length());
    }
}
