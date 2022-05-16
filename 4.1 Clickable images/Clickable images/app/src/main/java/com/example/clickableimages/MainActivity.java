package com.example.clickableimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    ImageView donutImageView, icreamImageView, froyoImageView;
    FloatingActionButton fabButton;
    String mTextMessageOrder = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImageView = findViewById(R.id.donut);
        icreamImageView = findViewById(R.id.ice_cream);
        froyoImageView = findViewById(R.id.froyo);

        fabButton = findViewById(R.id.fab_button);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mTextMessageOrder);
                startActivity(intent);
            }
        });

    }

    //disPlay Toast
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    //onClick Handler Functions
    public void showDonutOrder(View view) {
        mTextMessageOrder = getString(R.string.donut_order_message);
        displayToast(mTextMessageOrder);
    }

    public void showIceCreamOrder(View view) {
        mTextMessageOrder = getString(R.string.ice_cream_order_message);
        displayToast(mTextMessageOrder);
    }

    public void showFroyoOrder(View view) {
        mTextMessageOrder = getString(R.string.froyo_order_message);
        displayToast(mTextMessageOrder);
    }

}