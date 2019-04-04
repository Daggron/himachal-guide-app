package com.example.himachalguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.himachalguide.hotelsFragment.Key_Description;
import static com.example.himachalguide.hotelsFragment.Key_Image;
import static com.example.himachalguide.hotelsFragment.Key_Location;
import static com.example.himachalguide.hotelsFragment.Key_Name;

public class description extends AppCompatActivity {
    String name = "Name";
    String description= "Description";
    String location = "Loaction";
    int image =R.drawable.dreamland;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent i = getIntent();
        if(i!=null){
            name=i.getStringExtra(Key_Name);
            description=i.getStringExtra(Key_Description);
            location=i.getStringExtra(Key_Location);
            image=Integer.parseInt(i.getStringExtra(Key_Image));

        }


        TextView nameView = (TextView) findViewById(R.id.Name);
        nameView.setText(name);


        TextView locationView = (TextView) findViewById(R.id.Location);
        nameView.setText(location);

        TextView textView = (TextView) findViewById(R.id.Description);
        textView.setText(description);

        ImageView imageView = (ImageView) findViewById(R.id.Image);
        imageView.setImageResource(image);


    }
}
