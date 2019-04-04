package com.example.himachalguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class templesFragment extends Fragment {

    public static final String Key_Name="Key_Name";
    public static final String Key_Location="Key_Location";
    public static final String Key_Description="Key_Description";
    public static final String Key_Image="Key_Image";



    public templesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.list,container,false);

        ArrayList<places> temples = new ArrayList<>();

        temples.add(new places("Jawala Ji","Kangra","Jawala ji temple is the most famous temple in himachal pradesh people from diffrenet states come to visit the temple and this is the temple is also known for the gold which is now turned to an unkown metal which was donated by mughal emperor Akbar",R.drawable.jawalaji));

        temples.add(new places("Hadimba Temple","Manali","Hidimba Devi Temple, locally known as Dhungari Temple,[1] also known variously as the Hadimba Temple, is located in Manāli, a hill station in the State of Himāchal Pradesh in north India. It is an ancient cave temple dedicated to Hidimbi Devi, wife of Bhima, a figure in the Indian epic Mahābhārata. The temple is surrounded by a cedar forest called Dhungiri Van Vihar at the foot of the Himālayas. The sanctuary is built over a huge rock jutting out of the ground which was worshiped as an image of the deity. The structure was built in 1553.",R.drawable.hadimba));

        temples.add(new places("ChintPurni Temple","Una District","Chintpurni (Hindi: चिंतपूर्णी) is a major pilgrimage Centre and one of the Shakti Peethas in India. The Chintpurni shakti peeth (Chhinnamastika shakti peeth) is located in Una district Himachal Pradesh state, surrounded by the western Himalaya in the north and east in the smaller Shiwalik (or Shivalik) range bordering the state of Punjab.[1] The Chintpurni Shakti Peeth houses the temple of Chinnamastika Devi or Chinnamasta Devi. Chhinnamasta or Chinnamastika temple is one of the 7 major and 51 total Shakti Peethas.[2] ",R.drawable.chintpurni));

        temples.add(new places("Naina Devi Ji","Bilaspur","Naina Devi temple is a prominent temple in Bilaspur. The temple is situated about 70kms from Bilaspur and is dedicated to Naina Devi, an incarnation of Goddess Durga. According to legends, this sacred shrine is built in a place where one eye of Sati (Durga) fell when Lord Vishnu cut her body into 51 pieces in order to pacify an angry Lord Shiva. The temple is said to have been built by Raja Bir Chand in the 8th century. It is perched upon a hillock, which is now connected by a ropeway.",R.drawable.naina));

        final placeAdapter adapter = new placeAdapter(getActivity(),temples);




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
