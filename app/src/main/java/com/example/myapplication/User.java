package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.attr.data;

public class User extends AppCompatActivity {

    private TextView user_info;
    private Button return_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        user_info = (TextView) findViewById(R.id.user_info);
        return_back = (Button) findViewById(R.id.return_back);

        Intent intent = getIntent();
        String str = intent.getStringExtra("data");
        user_info.setText("[账号，密码]:"+str);

        return_back.setOnClickListener(mListener);
    }
    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(User.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
