package com.go.by.ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecuActivity extends AppCompatActivity {
    Button btn_recu;
    TextView depart,arrivee,prenom,nom,telephone,etat,nbPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recu);
        depart = (TextView) findViewById(R.id.depart);
        arrivee = (TextView) findViewById(R.id.arrivee);
        nom= findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        telephone = findViewById(R.id.telephone);
        etat = findViewById(R.id.etat);
        nbPlace=findViewById(R.id.nPlace);
        Intent intent=getIntent();
        String n=intent.getStringExtra("nom");
        String pren=intent.getStringExtra("prenom");
        String pl=intent.getStringExtra("place");
        String dep=intent.getStringExtra("depart");
        String arr=intent.getStringExtra("arrivee");
        String et=intent.getStringExtra("etat");
        String tel=intent.getStringExtra("telephone");

        depart.setText(dep);
        arrivee.setText(arr);
        nom.setText(n);
        prenom.setText(pren);
        telephone.setText(tel);
        etat.setText(et);
        nbPlace.setText(pl);



        btn_recu= (Button) findViewById(R.id.btn_recu);
        btn_recu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RecuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
