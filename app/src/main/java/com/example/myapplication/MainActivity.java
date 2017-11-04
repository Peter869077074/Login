package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public  class MainActivity extends AppCompatActivity {

    private Button login_button;
    private EditText account;
    private EditText pwd;
    private CheckBox remember;
    StringBuilder content = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pwd = (EditText) findViewById(R.id.password);
        account = (EditText) findViewById(R.id.username);
        remember = (CheckBox) findViewById(R.id.remember_pwd);
        login_button = (Button) findViewById(R.id.login);

        FileUtils.load(this,account,pwd);
        login_button.setOnClickListener(mListener);

    }
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login:
                    login();
                    break;

            }
        }
    };

    public void login(){
        if(isUserNameAndPwdValid()){
            String userName= account.getText().toString().trim();
            String userPwd = pwd.getText().toString().trim();


            content.append(userName+":"+userPwd);

//            strArray.add(userName);
//            strArray.add(userPwd);
            Intent intent = new Intent(MainActivity.this,User.class);
            intent.putExtra("data",content.toString());
            startActivity(intent);
            if(remember.isChecked()){
                FileUtils.save(this,account.getText().toString(),pwd.getText().toString());
            }
            finish();
        }
    }
    public boolean isUserNameAndPwdValid() {
        if (account.getText().toString().trim().equals("")) {
            Toast.makeText(this,"输入用户名为空",Toast.LENGTH_SHORT).show();
            return false;
        } else if (pwd.getText().toString().trim().equals("")) {
            Toast.makeText(this, "输入密码为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
