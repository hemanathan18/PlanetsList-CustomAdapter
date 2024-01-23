package com.example.planetslist_customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetArrayList;
    Context context;

    public CustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.planetlist_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    private static class ViewHolder{
        TextView planetName;
        TextView moons;
        ImageView planetImage;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet= getItem(position);

        ViewHolder viewHolder;
        final View result;

        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.planetlist_layout,parent,false);
            viewHolder.planetName=(TextView) convertView.findViewById(R.id.planetName);
            viewHolder.moons=(TextView) convertView.findViewById(R.id.moons);
            viewHolder.planetImage=(ImageView) convertView.findViewById(R.id.planetImage);
            result=convertView;
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moons.setText(planet.getMoonCount());
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}
