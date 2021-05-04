package com.example.lecture_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("ALC2","onCreate called");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC2","onStart called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC2","onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC2","onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC2","onDestroy called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("ALC2","onPostResume called");
    }

    public void Move(View view) {
        Intent intent =new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}