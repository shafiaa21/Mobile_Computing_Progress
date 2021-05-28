package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodordering.Adapters.MainAdapter;
import com.example.foodordering.Models.MainModel;
import com.example.foodordering.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.chickenburger2,"Burger","5","Chicken Burger with special cheese"));
        list.add(new MainModel(R.drawable.cheeseburger,"Burger","0","Chicken Burger with special cheese"));
        list.add(new MainModel(R.drawable.veggieburger,"Burger","12","Chicken Burger with special cheese"));
        list.add(new MainModel(R.drawable.pizza1,"Pizza","10","Chicken Burger with special cheese"));
        list.add(new MainModel(R.drawable.chickentikkapizza,"Pizza","5","Chicken Burger with special cheese"));

        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}