package com.example.myapplication;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.*;

/**
 * Created by Administrator on 2017/11/4/004.
 */

public class FileUtils {
    public static void save(Context context, String name, String pass) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = context.openFileOutput("data", context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.append(name + ":" + pass);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void load(Context context, EditText name, EditText pass) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = context.openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
                String str[] = new String[2];
                str = content.toString().split(":");
                name.setText(str[0]);
                pass.setText(str[1]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
