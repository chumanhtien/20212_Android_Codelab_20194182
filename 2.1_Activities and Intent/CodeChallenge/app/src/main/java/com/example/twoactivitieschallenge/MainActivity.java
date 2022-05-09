package com.example.twoactivitieschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mReplyTextView;
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyTextView = findViewById(R.id.text_message_reply);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LOG_TAG, "Button 1 Clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text_article_1 = getResources().getString(R.string.article_text_1);
                Log.v("LOG ARTICLE", text_article_1);
                intent.putExtra(EXTRA_MESSAGE, text_article_1);
                intent.putExtra("article_number", 1);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LOG_TAG, "Button 2 Clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text_article_2 = getResources().getString(R.string.article_text_2);
                intent.putExtra(EXTRA_MESSAGE, text_article_2);
                intent.putExtra("article_number", 2);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });

        findViewById(R.id.button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LOG_TAG, "Button 3 is Clicked");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text_article_3 = getResources().getString(R.string.article_text_3);
                intent.putExtra(EXTRA_MESSAGE, text_article_3);
                intent.putExtra("article_number", 3);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
            }
        }
    }
}