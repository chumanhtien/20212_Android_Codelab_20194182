package com.example.keyboarddialphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<String> items;
    ListView listView;
    Button buttonAdd, buttonUpdate, buttonRemove;
    Spinner spinner;
//    public static String final LOG_TAG =
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        items = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            items.add("Item " + i);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        //Layout định nghĩa
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.single_item_layout, R.id.text_view_content, items);

        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("TAG_SECONDACTIVITY", items.get(i) + " is Selected");
            }
        });

        buttonAdd = findViewById(R.id.button_add);
        buttonUpdate = findViewById(R.id.button_remove);
        buttonRemove = findViewById(R.id.button_remove);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add("New Item");
                adapter.notifyDataSetChanged();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.set(0,"Update Item");
                adapter.notifyDataSetChanged();

            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(0);
                adapter.notifyDataSetChanged();

            }
        });


        //Thiết lập dữ liệu cho Spinner
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(adapter2);
        //set mặc định
        spinner.setSelection(10);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("TAG_SECOND", items.get(i) + " is Selected");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







    }

}