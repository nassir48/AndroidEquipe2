package com.go.by.ter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReservationActivity extends AppCompatActivity {
    Spinner sp;
    Spinner sp2;
    ArrayAdapter<String> adapt;
    ArrayList<String> arrayList = new ArrayList<>();
    Button btn_reservation;
    ProgressDialog loadingBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        btn_reservation=findViewById(R.id.btn_reservation);
        loadingBar=new ProgressDialog(this);
        sp = findViewById(R.id.spDepart);
        sp2 = findViewById(R.id.spArret);
        arrayList.add("Dakar");
        arrayList.add("Colobane");
        arrayList.add("Hann");
        arrayList.add("Beaux Maraîchers");
        arrayList.add("Pikine");
        arrayList.add("Thiaroye");
        arrayList.add("Yeumbeul");
        arrayList.add("Keur Massar");
        arrayList.add(" Keur Mbaye Fall");
        arrayList.add("Rufisque");
        arrayList.add("Bargny");
        arrayList.add("Diamanadio");
        adapt = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, arrayList);
        sp.setAdapter(adapt);
        sp2.setAdapter(adapt);
        sp.setOnItemSelectedListener(sp.getOnItemSelectedListener());
        sp2.setOnItemSelectedListener(sp2.getOnItemSelectedListener());

        btn_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReservationActivity.this,OptionReservationActivity.class);
                startActivity(intent);
                loadingBar.setTitle("Reservation");
                loadingBar.setMessage("Veuillez patienter...........");
                loadingBar.setCanceledOnTouchOutside(true);
                loadingBar.show();
            }
        });
    }

}