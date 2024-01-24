package com.example.planetslist_customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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


        Planet mercury=new Planet("Mercury","0 Moon",R.drawable.mercury);
        Planet venus=new Planet("Venus","0 Moon",R.drawable.venus);
        Planet earth=new Planet("Earth","1 Moon",R.drawable.earth);
        Planet mars=new Planet("Mars","2 Moons",R.drawable.mars);
        Planet jupiter=new Planet("Jupiter","951 Moons",R.drawable.jupiter);
        Planet saturn=new Planet("Saturn","146 Moons",R.drawable.saturn);
        Planet uranus=new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet neptune=new Planet("Neptune","14 Moons",R.drawable.neptune);

        planetArrayList.add(mercury);
        planetArrayList.add(venus);
        planetArrayList.add(earth);
        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturn);
        planetArrayList.add(uranus);
        planetArrayList.add(neptune);


        adapter=new CustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Planet name: "+adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}