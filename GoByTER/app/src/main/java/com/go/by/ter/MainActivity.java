package com.go.by.ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private Button button2 ;
    private Button button1;
    private Button connexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button)findViewById(R.id.button2);
        button1=(Button)findViewById(R.id.button1);
        connexion= (Button) findViewById(R.id.connexion);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });
    }






}

