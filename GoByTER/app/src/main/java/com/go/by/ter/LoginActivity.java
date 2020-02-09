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
import android.widget.Toast;

import com.go.by.ter.model.Users;
import com.go.by.ter.prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    private EditText inputName,inputPasswd;
    private Button loginButton;
    private ProgressDialog loadingBar;
    private CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.btn_login);
        inputName=findViewById(R.id.login_name_input);
        inputPasswd=findViewById(R.id.login_password_input);
        loadingBar=new ProgressDialog(this);
        rememberMe=findViewById(R.id.souvenir_chkb);
        Paper.init(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String name= inputName.getText().toString();
        String password=inputPasswd.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"Veuillez votre nom",Toast.LENGTH_SHORT).show();
        }else
            if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Veuillez votre mot de passe",Toast.LENGTH_SHORT).show();
        }else{
                loadingBar.setTitle("Connexion");
                loadingBar.setMessage("Veuillez patienter, \n" +
                        "pendant que nous vérifions les informations d'identification");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

                AccesCompte(name,password);
            }

    }

    private void AccesCompte(final String name, final String password) {
        if(rememberMe.isChecked()){
            Paper.book().write(Prevalent.UserNameKey,name);
            Paper.book().write(Prevalent.UserPasswordKey,password);

        }

        final DatabaseReference rootRef;
        rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("Users").child(name).exists()){
                    Users usersData= dataSnapshot.child("Users").child(name).getValue(Users.class);


                    if(usersData.getName().equals(name)){
                        if(usersData.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Connexion succès !!!", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            Intent intent=new Intent(LoginActivity.this,AdminActivity.class);
                            startActivity(intent);
                        }else {
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Vous n'êtes pas un administrateur", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
