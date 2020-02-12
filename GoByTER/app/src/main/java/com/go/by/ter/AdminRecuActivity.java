package com.go.by.ter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.go.by.ter.model.Reservations;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AdminRecuActivity extends AppCompatActivity {
    Button btn_recu;
    TextView depart,arrivee,prenom,nom,telephone,etat,nbPlace,tarif,frais,facture;

    int prix;
    String code="";
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
        code=intent.getStringExtra("code");
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
                update();

            }
        });
    }

    private void update() {
        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Reservations").child(code).exists()){
                    HashMap<String, Object> userDataMap= new HashMap<>();
                    userDataMap.put("etat","Utilisé");
                    rootRef.child("Reservations").child(code).updateChildren(userDataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent= new Intent(AdminRecuActivity.this,LoginRecuActivity.class);
                            startActivity(intent);
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
