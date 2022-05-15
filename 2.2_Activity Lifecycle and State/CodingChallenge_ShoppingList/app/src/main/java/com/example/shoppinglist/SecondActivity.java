package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SecondActivity extends AppCompatActivity {

    public static final String LOG_TAG = SecondActivity.class.getSimpleName();
    CheckBox[] shopItem = new CheckBox[5];
    Button addToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        shopItem[0] = findViewById(R.id.shop_item_1);
        shopItem[1] = findViewById(R.id.shop_item_2);
        shopItem[2] = findViewById(R.id.shop_item_3);
        shopItem[3] = findViewById(R.id.shop_item_4);
        shopItem[4] = findViewById(R.id.shop_item_5);

        addToCart = findViewById(R.id.add_to_cart);


        shopItem[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopItem[0].isChecked()) {
                    Log.v(LOG_TAG, shopItem[0].getText().toString() + " is Checked");
                }
                else {
                    Log.v(LOG_TAG, shopItem[0].getText().toString() + " is unChecked");
                }
            }
        });
        shopItem[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopItem[1].isChecked()) {
                    Log.v(LOG_TAG, shopItem[1].getText().toString() + " is Checked");
                }
                else {
                    Log.v(LOG_TAG, shopItem[1].getText().toString() + " is unChecked");
                }
            }
        });
        shopItem[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopItem[2].isChecked()) {
                    Log.v(LOG_TAG, shopItem[2].getText().toString() + " is Checked");
                }
                else {
                    Log.v(LOG_TAG, shopItem[2].getText().toString() + " is unChecked");
                }
            }
        });
        shopItem[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopItem[3].isChecked()) {
                    Log.v(LOG_TAG, shopItem[3].getText().toString() + " is Checked");
                }
                else {
                    Log.v(LOG_TAG, shopItem[3].getText().toString() + " is unChecked");
                }
            }
        });
        shopItem[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shopItem[4].isChecked()) {
                    Log.v(LOG_TAG, shopItem[4].getText().toString() + " is Checked");
                }
                else {
                    Log.v(LOG_TAG, shopItem[4].getText().toString() + " is unChecked");
                }
            }
        });


        //Click Add Button
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LOG_TAG, "Add to Cart");
                Intent replyIntent = new Intent();
                String key_i;
                for (int i = 0; i < 5; i++) {
                    key_i = "item_" + (i + 1);
                    if (shopItem[i].isChecked()) {
                        replyIntent.putExtra(key_i, shopItem[i].getText().toString());
                    }
                    else {
                        replyIntent.putExtra(key_i, "");
                    }
                }

                setResult(RESULT_OK, replyIntent);
                finish();

            }
        });




    }
}