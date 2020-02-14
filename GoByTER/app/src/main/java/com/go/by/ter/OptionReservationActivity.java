package com.go.by.ter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.go.by.ter.model.Reservations;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.HashMap;

public class OptionReservationActivity extends AppCompatActivity {
    Button btn_generer;
    EditText nom, prenom,phone;
    ProgressDialog progressDialog;
    String inputNbPlace="";
    String inputDepart="";
    String inputArrivee="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_reservation);
        Intent intent=getIntent();

                inputNbPlace=intent.getStringExtra("place");

                inputDepart=intent.getStringExtra("depart");

                inputArrivee=intent.getStringExtra("arrivee");

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);

        phone=findViewById(R.id.phone);
        progressDialog= new ProgressDialog(this);
        btn_generer= findViewById(R.id.generer_recu);
        btn_generer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genererRecu();
            }
        });
    }

    private void genererRecu() {
        Date date=new Date();
        long temps=date.getTime();
        String inputName=nom.getText().toString();
        String inputPrenom=prenom.getText().toString();

        String inputPhone=phone.getText().toString();
        if(TextUtils.isEmpty(inputName)){
            Toast.makeText(this, "Veuillez saisir votre nom", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(inputPrenom)){
            Toast.makeText(this, "Veuillez saisir votre prenom", Toast.LENGTH_SHORT).show();
        } else if(TextUtils.isEmpty(inputPhone)){
            Toast.makeText(this, "Veuillez saisir votre numero de téléphone ", Toast.LENGTH_SHORT).show();
        } else if(inputPhone.length()!=9){
            Toast.makeText(this, "Votre numero de téléphone doit contenir 9 chiffres ", Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.setTitle("Génération de ticket");
            progressDialog.setMessage("Veuillez patienter pendant que nous vérifions les identifiants");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            ajoutALaBase(temps,inputName,inputPrenom,inputNbPlace,inputPhone,inputDepart,inputArrivee);
        }



    }

    private void ajoutALaBase(final long temps, final String inputName, final String inputPrenom, final String inputNbPlace, final String inputPhone, final String inputDepart, final String inputArrivee) {
        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        final String jour= temps+"";
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Reservations").child(jour).exists())){
                    HashMap<String, Object> userDataMap= new HashMap<>();
                    userDataMap.put("prenom",inputPrenom);
                    userDataMap.put("nom",inputName);
                    userDataMap.put("telephone",inputPhone);
                    userDataMap.put("nbPlace",inputNbPlace);
                    userDataMap.put("jour",jour);
                    userDataMap.put("depart",inputDepart);
                    userDataMap.put("arrivee",inputArrivee);
                    userDataMap.put("etat","Non utilisé");
                    rootRef.child("Reservations").child(jour).updateChildren(userDataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(OptionReservationActivity.this, "Ticket généré avec succès.....", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else{
                                progressDialog.dismiss();
                                Toast.makeText(OptionReservationActivity.this, "Erreur de connection à l'internet! " +
                                        "Veuillez ressayer plus tard...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    accesBase(jour);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void accesBase(final String telephone) {
        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Reservations").child(telephone).exists()){
                    Reservations reservation= dataSnapshot.child("Reservations").child(telephone).getValue(Reservations.class);
                    Intent intent = new Intent(OptionReservationActivity.this,RecuActivity.class);
                    intent.putExtra("prenom",reservation.getPrenom());
                    intent.putExtra("nom",reservation.getNom());
                    intent.putExtra("place",reservation.getNbPlace());
                    intent.putExtra("depart",reservation.getDepart());
                    intent.putExtra("arrivee",reservation.getArrivee());
                    intent.putExtra("etat",reservation.getEtat());
                    intent.putExtra("telephone",reservation.getTelephone());
                    intent.putExtra("code",reservation.getJour());
                    startActivity(intent);
                }else
                    Toast.makeText(OptionReservationActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
