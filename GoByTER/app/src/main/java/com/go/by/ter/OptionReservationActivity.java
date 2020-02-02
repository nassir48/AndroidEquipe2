package com.go.by.ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionReservationActivity extends AppCompatActivity {
Button btn_generer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_reservation);
        btn_generer= findViewById(R.id.generer_recu);
        btn_generer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(OptionReservationActivity.this,RecuActivity.class);
                startActivity(intent);
            }
        });
    }
}
