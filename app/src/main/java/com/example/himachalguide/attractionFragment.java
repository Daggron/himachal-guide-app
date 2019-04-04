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
public class attractionFragment extends Fragment {

    public static final String Key_Name="Key_Name";
    public static final String Key_Location="Key_Location";
    public static final String Key_Description="Key_Description";
    public static final String Key_Image="Key_Image";



    public attractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.list,container,false);

        ArrayList<places> attractions = new ArrayList<>();

        attractions.add(new places("Himalaya Wonder Land","Dharamshala","A theme Park located in Dharamashala City of himachal.",R.drawable.wonderland_4_36));

        attractions.add(new places("Manikaran Hot water Spring","Manikaran","A hot water spring and the land of scenic vistas in Himachal.",R.drawable.manikaran));

        attractions.add(new places("Solang Valley","Manali","Located in Manali the solang valley is one of the most beautiful valley in the manali.",R.drawable.solang) );

        attractions.add(new places("Bijli Mahadev","Manali","Located in Manali the Bijli Mahadev  is one of most the oldest temple Lord Shiva and the top of the hill provide the full view of manali city.",R.drawable.bijlimahadev) );

        attractions.add(new places("Triund Track","Dharamshala","Triund track is a 9 k.m. mountain track in the triund valley of kangra district of Himachal",R.drawable.triund) );

        attractions.add(new places("Ridge","Shimla","The shimla is the queen of hills and the most beautiful city in the himachal",R.drawable.shimla));




        final placeAdapter attractionAdapter = new placeAdapter(getActivity(),attractions);

        GridView listView = rootview.findViewById(R.id.List);
        listView.setAdapter(attractionAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getContext(),description.class);
                places place = (places) attractionAdapter.getItem(position);
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
