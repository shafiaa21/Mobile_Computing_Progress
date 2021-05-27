package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button Button1, Button2, Button3;
    LinearLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button1 = findViewById(R.id.btn_1);
        Button2 = findViewById(R.id.btn_2);
        Button3 = findViewById(R.id.btn_3);
        myLayout = findViewById(R.id.linearLayout);


    }
}