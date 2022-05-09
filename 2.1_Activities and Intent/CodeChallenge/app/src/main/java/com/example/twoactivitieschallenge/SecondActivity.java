package com.example.twoactivitieschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String article_text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.article_text);
        textView.setVisibility(View.VISIBLE);
        textView.setText(article_text);

        String replyString="";
        TextView articleHeading = findViewById(R.id.article_heading);
        int article_number = intent.getIntExtra("article_number", 0);
        if (article_number == 1) {
            articleHeading.setText("Article One");
            replyString = "You've alredy read Article One";
        }
        else if (article_number == 2) {
            articleHeading.setText("Article Two");
            replyString = "You've alredy read Article Two";
        }
        else if (article_number == 3) {
            articleHeading.setText("Article Three");
            replyString = "You've alredy read Article Three";
        }


        //Return
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, replyString);
        setResult(RESULT_OK, replyIntent);
    }
}