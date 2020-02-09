package com.go.by.ter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.go.by.ter.model.Users;
import com.go.by.ter.prevalent.Prevalent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    private Button button2 ;
    private Button button1;
    private Button connexion;
    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (Button)findViewById(R.id.button2);
        button1=(Button)findViewById(R.id.button1);
        connexion= (Button) findViewById(R.id.connexion);
        loadingBar= new ProgressDialog(this);
        Paper.init(this);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LocalisationArretActivity.class);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.connexion) {
            Intent intent= new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}
