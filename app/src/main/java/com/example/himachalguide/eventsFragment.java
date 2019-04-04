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
public class eventsFragment extends Fragment {
    public static final String Key_Name="Key_Name";
    public static final String Key_Location="Key_Location";
    public static final String Key_Description="Key_Description";
    public static final String Key_Image="Key_Image";


    public eventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.list,container,false);

        ArrayList<places> events = new ArrayList<>();
        events.add(new places("Minjar Fair","Chamba","This festival is held in the month of August on second Sunday. It continues for a week. Minjar ( maize flowers) festival is celebrated in district Chamba at a place 'Chowgan' in Chamba town.Maize flowers, a coconut, a rupee or a smaller coin, a fruit and a few paddy tentacles are offered to Varuna, the god of rain. It is a state fair. It is difficult to say, when the fair first started, but the present form of the fair is attributed to Raja Sahil Verman, who ruled the state in the 10th century A.D.",R.drawable.minjar));
        events.add(new places("Kullu Dushehra","Kullu","Kullu Dushehra mirrors Himachal culture in its entirely.. It clearly shows the lefestyle, love of dance and music of the people in this region. To see the colorful Himachal at one place, Kullu Dushehra is the right place. Although Dushehra is celebrated all over the country, but in Kullu, it has its own distinctive glamour. This is a state fair.People from Punjab, Haryana, Delhi and Uttar Pradesh throng to enjoy Kullu Dushehra.",R.drawable.kullu));
        events.add(new places("Lavi Fair","Rampur Bushar","This fair is held in the month of October or November every at Rampur Bushahr. In ancient, Tibet and Kinnaur had good trade relations and Lavi fair is the outcome of business interest of both sides. People from other areas in general and tribal belt in particular participate in this fair with horses, mules, pashminas, colts, yaks, chilgoza, namdas, pattis, woollens, raw semi-finished wool and other dry fruits produced in the state are brought for selling. It is three hundred years old fair and also a state fair.4 During day time, hectic trade activities are witnessed all over the town. At night, folks dances and music around small bonfires are organised. It continues for three days.",R.drawable.lavi));
        events.add(new places("Holi Fair","Sujanpur,Hamirpur","It is held in the month of March every year. Especially the Holi Mela of Sujanpur in district Hamirpur is very famous. It is the festival of colors. People all over Himachal come to participate in it. A week long fair provides wholesome entertainment through various games, songs, dances, folk dramas and skits performed by local artists/ Business activities are also in full swing throughout the week.",R.drawable.holi));
        events.add(new places("Solan Fair","Solan","Solan fair is held in the last week of June for three days. This fair is celebrated even before the present Solan town was founded in honour of the goddess 'Shulini' whose temple is situated in the nearby village named Solan Gaon. It attracts traders, sweetsellers, general merchants and other shopkeepers to make brisk business. The highlight of this fair are dancing, singing and wrestling.",R.drawable.solan));

        GridView gridView = rootview.findViewById(R.id.List);
        final placeAdapter adapter = new placeAdapter(getActivity(),events);
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
