package com.go.by.ter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.go.by.ter.model.Reservations;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginRecuActivity extends AppCompatActivity {
    EditText code;
    Button generer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_recu);

        code = findViewById(R.id.telephone);
        generer = findViewById(R.id.btn_recu);

        generer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verification();
            }
        });
    }

    private void verification() {
        String inputPhone= code.getText().toString();
        if (TextUtils.isEmpty(inputPhone)){
            Toast.makeText(this, "Veuillez saisir le code", Toast.LENGTH_SHORT).show();
        }else if (inputPhone.length()<13 || inputPhone.length()>13){
            Toast.makeText(this, "Le code doit contenir 13 chiffres", Toast.LENGTH_SHORT).show();

        }else{
            accesBase(inputPhone);
        }
    }

    private void accesBase(final String telephone) {
        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Reservations").child(telephone).exists()){
                    Reservations reservation= dataSnapshot.child("Reservations").child(telephone).getValue(Reservations.class);
                    if (reservation.getEtat().equals("Non utilisé")) {
                        Intent intent = new Intent(LoginRecuActivity.this, RecuActivity.class);
                        intent.putExtra("prenom", reservation.getPrenom());
                        intent.putExtra("nom", reservation.getNom());
                        intent.putExtra("place", reservation.getNbPlace());
                        intent.putExtra("depart", reservation.getDepart());
                        intent.putExtra("arrivee", reservation.getArrivee());
                        intent.putExtra("etat", reservation.getEtat());
                        intent.putExtra("telephone", reservation.getTelephone());
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginRecuActivity.this, "Désolé le billet à été utilisé", Toast.LENGTH_LONG).show();
                    }
                }else
                    Toast.makeText(LoginRecuActivity.this, "Le code saisi n'esxiste pas !", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
