package com.example.himachalguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class attractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.List, new hotelsFragment())
                .commit();
    }
}
