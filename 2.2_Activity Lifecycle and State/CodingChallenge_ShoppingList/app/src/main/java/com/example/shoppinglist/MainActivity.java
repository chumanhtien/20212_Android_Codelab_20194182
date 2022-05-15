package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 123;

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    TextView listItemText;
    TextView [] chosenItems = new TextView[10];
    Button showItems, addItems, clearChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOG_TAG, "onCreate");

        setContentView(R.layout.activity_main);
        showItems = findViewById(R.id.show_item);
        addItems = findViewById(R.id.add_item);
        clearChoices = findViewById(R.id.clear_choices);

        listItemText = findViewById(R.id.list_items);
        chosenItems[0] = findViewById(R.id.text_item_1);
        chosenItems[1] = findViewById(R.id.text_item_2);
        chosenItems[2] = findViewById(R.id.text_item_3);
        chosenItems[3] = findViewById(R.id.text_item_4);
        chosenItems[4] = findViewById(R.id.text_item_5);
        chosenItems[5] = findViewById(R.id.text_item_6);
        chosenItems[6] = findViewById(R.id.text_item_7);
        chosenItems[7] = findViewById(R.id.text_item_8);
        chosenItems[8] = findViewById(R.id.text_item_9);
        chosenItems[9] = findViewById(R.id.text_item_10);

        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, TEXT_REQUEST);
            }
        });

        showItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(LOG_TAG, "Show Chosen Items");
                int visible = listItemText.getVisibility();
                if (visible == View.VISIBLE) {
                    listItemText.setVisibility(View.INVISIBLE);
                    for (int i = 0; i < 10; i++) {
                        chosenItems[i].setVisibility(View.INVISIBLE);
                    }
                }
                else if (visible == View.INVISIBLE) {
                    listItemText.setVisibility(View.VISIBLE);
                    for (int i = 0; i < 10; i++) {
                        chosenItems[i].setVisibility(View.VISIBLE);
                    }
                }



            }
        });
        clearChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 10; i++) {
                    chosenItems[i].setText("");
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(LOG_TAG, "onSaveInstanceState");
        if (listItemText.getVisibility() == View.VISIBLE) {
            outState.putBoolean("list_visible", true);
        }
        String key_i;
        for (int i = 0; i < 10; i++) {
            key_i = "chosen_item_" + (i + 1);
            outState.putString(key_i, chosenItems[i].getText().toString());
        }

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(LOG_TAG, "onRestoreInstanceState");
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("list_visible");
            if (isVisible) {
                listItemText.setVisibility(View.VISIBLE);
                String key_i, string_item_i;
                for (int i = 0; i < 10; i++) {
                    key_i = "chosen_item_" + (i + 1);
                    string_item_i = savedInstanceState.getString(key_i);
                    chosenItems[i].setText(string_item_i);
                    chosenItems[i].setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v(LOG_TAG, "onActivityResult");

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String key_i, item_i;
                int k = 0;
                for (int i = 0; i < 5; i++) {
                    key_i = "item_" + (i + 1);
                    item_i = data.getStringExtra(key_i);
                    Log.v("ITEM", item_i);
                    if (!item_i.equals("")) {
                        chosenItems[k].setText(item_i);
                        k++;
                    }
                }
            }
        }

    }
}