package com.example.clickableimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String mTextMessageOrder;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        textView = findViewById(R.id.text_view_order);

        Intent intent = getIntent();

        mTextMessageOrder = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        if (!mTextMessageOrder.equals("")) {
            textView.setText(mTextMessageOrder);
        }
        else {
            textView.setText("You don't order anything!");
        }

    }
}