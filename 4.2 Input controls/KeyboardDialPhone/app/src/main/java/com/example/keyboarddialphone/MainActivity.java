package com.example.keyboarddialphone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    List<String> items;
    Button buttonOpeSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<String>();
        for (int i = 0; i < 50; i++)
            items.add("Item " + i);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.single_item_layout, R.id.text_view_content, items);
        // ArrayAdapter trên có 4 tham số,
        /*
        * param 1: context: Activity hiện tại
        * param 2: layout muốn set cho item trong Listview
        * param 3: dữ liệu của item sẽ match đối với thành phần của layout được  truyền
        * layout có thể có nhiều đối tượng , tuy nhiên dữ liệu chỉ tuân theo format của đối tượng truyền ở param 3, các cái khác thì nó sẽ hiện thêm vào item
        * ... param 4 (cuối cùng): danh sách các items: truyền vào adapter => set Adapter cho Layout chính
        * */
        setListAdapter(adapter);

        buttonOpeSecond = findViewById(R.id.button_open_second);

        buttonOpeSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String itemSelected = items.get(position);

        Log.v("TAG", itemSelected + " is Selected");


    }
}