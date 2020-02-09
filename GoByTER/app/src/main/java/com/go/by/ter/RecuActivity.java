package com.go.by.ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecuActivity extends AppCompatActivity {
    Button btn_recu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recu);

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
