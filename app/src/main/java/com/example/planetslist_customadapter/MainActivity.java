package com.example.planetslist_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Planet> planetArrayList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listView);
        planetArrayList=new ArrayList<>();

        Planet earth=new Planet("Earth","1 Moon",R.drawable.earth);
        planetArrayList.add(earth);

        adapter=new CustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);
    }
}