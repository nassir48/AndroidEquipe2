package com.go.by.ter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.go.by.ter.model.Users;
import com.go.by.ter.prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private Button button2 ;
    private Button button1;
    private Button connexion;
    private ProgressDialog  loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button)findViewById(R.id.button2);
        button1=(Button)findViewById(R.id.button1);
        connexion= (Button) findViewById(R.id.connexion);
        loadingBar= new ProgressDialog(this);
        Paper.init(this);
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

        String UserNameKey = Paper.book().read(Prevalent.UserNameKey);
        String UserPassword = Paper.book().read(Prevalent.UserPasswordKey);

        if(UserNameKey!="" && UserPassword!="" ){
            if (!TextUtils.isEmpty(UserNameKey) && !TextUtils.isEmpty(UserPassword)){
                allowAccess(UserNameKey,UserPassword);

                loadingBar.setTitle("Vous êtes déjà connecté");
                loadingBar.setMessage("Veuillez patienter..........................");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
            }
        }
    }

    private void allowAccess(final String userNameKey, final String userPassword) {
        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Users").child(userNameKey).exists()){
                    Users usersData= dataSnapshot.child("Users").child(userNameKey).getValue(Users.class);

                    if(usersData.getName().equals(userNameKey)){
                        if(usersData.getPassword().equals(userPassword)){
                            Toast.makeText(MainActivity.this, "Connexion succès !!!", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent=new Intent(MainActivity.this,AdminActivity.class);
                            startActivity(intent);
                        }else {
                            loadingBar.dismiss();
                            Toast.makeText(MainActivity.this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Vous n'êtes pas un administrateur", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}

