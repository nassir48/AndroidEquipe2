package com.go.by.ter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.rey.material.widget.TextView;

public class LocalisationArretActivity extends AppCompatActivity {

    private Button button2 ;
    private Button button1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation_arret);

        button2 = (Button)findViewById(R.id.button2);
        button1=(Button)findViewById(R.id.button1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LocalisationArretActivity.this, ArretActivity.class);
                startActivity(intent);
            }
        });


    }
}
