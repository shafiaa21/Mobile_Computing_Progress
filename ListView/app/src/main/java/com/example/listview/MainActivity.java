package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.myListView);
        String[] friendList={"Ali","Saad","Musa","Zia"};
        ArrayList<String> friendArrayList=new ArrayList<String>();
        friendArrayList.add("Ali");
        friendArrayList.add("Babar");
        friendArrayList.add("Shahid");
        friendArrayList.add("Yasir");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(arrayAdapter);

    }
}