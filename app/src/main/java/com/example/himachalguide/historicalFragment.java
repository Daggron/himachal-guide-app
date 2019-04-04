package com.example.himachalguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class historicalFragment extends Fragment {

    public static final String Key_Name="Key_Name";
    public static final String Key_Location="Key_Location";
    public static final String Key_Description="Key_Description";
    public static final String Key_Image="Key_Image";


    public historicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.list,container,false);

        ArrayList<places> historicalsite = new ArrayList<>();
        historicalsite.add(new places("Kangra Fort","Kangra","Kangra fort is the oldest fort in the himachal",R.drawable.kangrafort));

        historicalsite.add(new places("The Ridge","Shimla","The Ridge is the ground of shimla with a beautiful christ church and scenic vistas",R.drawable.ridge));

        historicalsite.add(new places("Peterhoff","Shimla","The Peterhof housed at least seven Viceroys and Governor Generals during the Raj. The first Viceroy to move into Peterhoff was the Earl of Elgin who arrived in Shimla on 4th April 1863.",R.drawable.peterhoff));

        historicalsite.add(new places("Key Monastery","Spiti valley","The Key Monastery is a famous Tibetan Buddhist monastery in the Lahaul and Spiti District of India. Located at an altitude of 4,166 metres above the sea level, the monastery is very close to the Spiti River in the Spiti Valley of Himachal Pradesh in India",R.drawable.key));


        final placeAdapter adapter = new placeAdapter(getActivity(),historicalsite);

        GridView gridView = rootview.findViewById(R.id.List);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(),description.class);
                places place = (places) adapter.getItem(position);
                i.putExtra(Key_Name,place.getMname());
                i.putExtra(Key_Location,place.getMLocation());
                i.putExtra(Key_Description,place.getMdescription());
                i.putExtra(Key_Image,Integer.toString(place.getmImage()));

                startActivity(i);
            }
        });




        return rootview;
    }

}
