package com.example.lecture_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC3","onStart called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC3","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC3","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC3","onDestroy called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("ALC3","onPostResume called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("ALC3","onCreate called");
    }
}