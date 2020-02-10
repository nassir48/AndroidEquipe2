package com.go.by.ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminRecuActivity extends AppCompatActivity {
    Button btn_recu;
    TextView depart,arrivee,prenom,nom,telephone,etat,nbPlace,tarif,frais,facture;

    int prix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_recu);
        depart = (TextView) findViewById(R.id.departA);
        arrivee = (TextView) findViewById(R.id.arriveeA);
        nom= findViewById(R.id.nomA);
        prenom = findViewById(R.id.prenomA);
        telephone = findViewById(R.id.telephoneA);
        etat = findViewById(R.id.etatA);
        nbPlace=findViewById(R.id.nPlaceA);
        tarif = findViewById(R.id.prixA);
        frais= findViewById(R.id.fraisA);
        facture = findViewById(R.id.factureA);
        Intent intent=getIntent();
        String n=intent.getStringExtra("nom");
        String pren=intent.getStringExtra("prenom");
        String pl=intent.getStringExtra("place");
        String dep=intent.getStringExtra("depart");
        String arr=intent.getStringExtra("arrivee");
        String et=intent.getStringExtra("etat");
        String tel=intent.getStringExtra("telephone");
        String p=pl;
        prix=1500*(Integer.parseInt(p));
        tarif.setText(prix+" FCFA");
        depart.setText(dep);
        arrivee.setText(arr);
        nom.setText(n);
        prenom.setText(pren);
        telephone.setText(tel);
        etat.setText(et);
        nbPlace.setText(pl);
        int f=100*(Integer.parseInt(p));
        frais.setText(f+"");
        facture.setText("Vous êtes facturé(e) de "+(prix+f)+" FCFA");


        btn_recu= (Button) findViewById(R.id.btn_recu_valider);
        btn_recu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminRecuActivity.this,LoginRecuActivity.class);
                startActivity(intent);
            }
        });
    }
}
