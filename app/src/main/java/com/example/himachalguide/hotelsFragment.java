package com.example.himachalguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
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
public class hotelsFragment extends Fragment {

    public static final String Key_Name="Key_Name";
    public static final String Key_Location="Key_Location";
    public static final String Key_Description="Key_Description";
    public static final String Key_Image="Key_Image";

    public hotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.list, container,false);

         final ArrayList<places> place = new ArrayList<places>();

        place.add(new places("Hotel Greenfields","Manali","Nestled in the Himalayas and surrounded by cedar trees, this laid-back hotel is 2.2 km from Hidimba Devi Temple, 15 km from the Solang Valley and 20 km from Bhrigu Lake.",R.drawable.hotel1));
        place.add(new places("Dream Land","old manali","Flanked by the mountains of the Himalayas and across from the Manalsu River, this modest hotel is 1 km from scenic views at the serene Manu Temple and 2 km from the NH3.",R.drawable.dreamland));
        place.add(new places("Rock Top Cottage","Shimla","Nice and great hotels at very cheap price",R.drawable.hotel2));
        place.add(new places("Chopra residency","Hamirpur","Prem naam hai mera prem chopra",R.drawable.chopra));

        GridView gridView = rootview.findViewById(R.id.List);

        final placeAdapter adapter = new placeAdapter(getActivity(),place);

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
