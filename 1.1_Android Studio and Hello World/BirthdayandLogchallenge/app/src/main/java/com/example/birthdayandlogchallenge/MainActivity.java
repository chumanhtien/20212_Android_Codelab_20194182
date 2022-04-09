package com.example.birthdayandlogchallenge;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 0;
        int b = 1;
        try {
            int c = b / a;
            c = c + 1;
        }
        catch (Exception err) {
            Log.e("Error Exception: ", String.valueOf(err));
        }
    }
}