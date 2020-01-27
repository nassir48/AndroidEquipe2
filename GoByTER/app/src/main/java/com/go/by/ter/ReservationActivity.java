package com.go.by.ter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReservationActivity extends AppCompatActivity {
    Spinner sp;
    Spinner sp2;
    ArrayAdapter<String> adapt;
    ArrayList<String> arrayList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reservation);
        sp = findViewById(R.id.spDepart);
        sp2 = findViewById(R.id.spArret);
        arrayList.add("arret 1");
        arrayList.add("arret 2");
        arrayList.add("arret 3");
        arrayList.add("arret 4");
        arrayList.add("arret 5");
        arrayList.add("arret 6");
        adapt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, arrayList);
        sp.setAdapter(adapt);
        sp2.setAdapter(adapt);
        sp.setOnItemSelectedListener(sp.getOnItemSelectedListener());
        sp2.setOnItemSelectedListener(sp2.getOnItemSelectedListener());


    }
}
