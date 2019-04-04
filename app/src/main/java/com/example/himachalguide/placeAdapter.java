package com.example.himachalguide;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class placeAdapter extends ArrayAdapter<places> {

    placeAdapter(Context context, ArrayList<places> places){
        super(context,0,places);
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        View listitemview = convertView;

        if(listitemview==null){
            listitemview= LayoutInflater.from(getContext()).inflate(
                    R.layout.card_resource, parent, false);
        }

        places eachplace = getItem(position);


        TextView name = listitemview.findViewById(R.id.Name);
        name.setText(eachplace.getMname());

        TextView location = listitemview.findViewById(R.id.Location);
        location.setText(eachplace.getMLocation());

        ImageView image = listitemview.findViewById(R.id.Image);
        image.setImageResource(eachplace.getmImage());





        return listitemview;
    }
}
