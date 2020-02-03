package com.go.by.ter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArretActivity  extends AppCompatActivity {


    Button btn_dakar;
    Button btn_colobane;
    Button btn_hanne;
    Button btn_bMaraichers;
    Button btn_pikine;
    Button btn_thiaroye;
    Button btn_yeumbeul;
    Button btn_kMassar;
    Button btn_kMFall;
    Button btn_rufisque;
    Button btn_bargny;
    Button btn_diamnadio;
    TextView aller1,aller2,aller3,aller4;
    TextView retour1,retour2,retour3,retour4;
    TextView info_arret;
    Dialog myDialog;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arret);


        myDialog= new Dialog(this);

        btn_dakar=findViewById(R.id.btn_dakar);
        btn_colobane=findViewById(R.id.btn_colobane);
        btn_hanne=findViewById(R.id.btn_hanne);
        btn_bMaraichers=findViewById(R.id.btn_bMaraichers);
        btn_pikine=findViewById(R.id.btn_pikine);
        btn_thiaroye=findViewById(R.id.btn_thiaroye);
        btn_yeumbeul=findViewById(R.id.btn_yeumbeul);
        btn_kMassar=findViewById(R.id.btn_kMassar);
        btn_kMFall=findViewById(R.id.btn_kMFall);
        btn_rufisque=findViewById(R.id.btn_rufisque);
        btn_bargny=findViewById(R.id.btn_bargny);
        btn_diamnadio=findViewById(R.id.btn_diamnadio);




        btn_dakar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Dakar");
                aller1.append("06h00");
                retour1.append("08h10");
                aller2.append("10h20");
                retour2.append("11h00");
                aller3.append("12h00");
                retour3.append("14h10");
                aller4.append("16h40");
                retour4.append("18h00");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();

            }
        });
        btn_colobane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Colobane");
                aller1.append("06h10");
                retour1.append("08h00");
                aller2.append("10h40");
                retour2.append("11h50");
                aller3.append("12h10");
                retour3.append("14h00");
                aller4.append("16h50");
                retour4.append("17h50");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_hanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Hanne");
                aller1.append("06h20");
                retour1.append("07h50");
                aller2.append("10h30");
                retour2.append("11h40");
                aller3.append("12h20");
                retour3.append("13h50");
                aller4.append("17h00");
                retour4.append("17h40");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_bMaraichers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Beaux Maraichers");
                aller1.append("06h30");
                retour1.append("07h40");
                aller2.append("10h40");
                retour2.append("11h30");
                aller3.append("12h30");
                retour3.append("13h40");
                aller4.append("17h10");
                retour4.append("17h30");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_pikine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Pikine");
                aller1.append("06h40");
                retour1.append("07h30");
                aller2.append("10h50");
                retour2.append("11h20");
                aller3.append("12h40");
                retour3.append("13h30");
                aller4.append("17h20");
                retour4.append("18h00");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_thiaroye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Thiaroye");
                aller1.append("06h50");
                retour1.append("07h20");
                aller2.append("11h00");
                retour2.append("11h40");
                aller3.append("12h50");
                retour3.append("13h10");
                aller4.append("17h30");
                retour4.append("18h10");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_yeumbeul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Yeumbeul");
                aller1.append("07h00");
                retour1.append("08h00");
                aller2.append("11h10");
                retour2.append("11h30");
                aller3.append("12h30");
                retour3.append("13h20");
                aller4.append("15h30");
                retour4.append("17h10");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_kMassar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Keur Massar");
                aller1.append("07h10");
                retour1.append("07h50");
                aller2.append("11h20");
                retour2.append("12h00");
                aller3.append("13h30");
                retour3.append("14h10");
                aller4.append("15h40");
                retour4.append("17h00");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_kMFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Keur Mbaye Fall");
                aller1.append("07h20");
                retour1.append("08h00");
                aller2.append("11h00");
                retour2.append("11h50");
                aller3.append("13h40");
                retour3.append("14h20");
                aller4.append("15h50");
                retour4.append("16h50");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_rufisque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Rufisque");
                aller1.append("07h30");
                retour1.append("07h50");
                aller2.append("11h10");
                retour2.append("12h00");
                aller3.append("13h50");
                retour3.append("14h40");
                aller4.append("16h00");
                retour4.append("16h40");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_bargny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Bargny");
                aller1.append("07h35");
                retour1.append("07h45");
                aller2.append("11h20");
                retour2.append("11h40");
                aller3.append("14h00");
                retour3.append("14h20");
                aller4.append("16h10");
                retour4.append("16h30");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
        btn_diamnadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDialog.setContentView(R.layout.activity_info_arret);
                aller1=(TextView) myDialog.findViewById(R.id.aller_1);
                retour1= (TextView) myDialog.findViewById(R.id.retour_1);
                aller2=(TextView) myDialog.findViewById(R.id.aller_2);
                retour2= (TextView) myDialog.findViewById(R.id.retour_2);
                aller3=(TextView) myDialog.findViewById(R.id.aller_3);
                retour3= (TextView) myDialog.findViewById(R.id.retour_3);
                aller4=(TextView) myDialog.findViewById(R.id.aller_4);
                retour4= (TextView) myDialog.findViewById(R.id.retour_4);
                info_arret=(TextView) myDialog.findViewById(R.id.info_Arret);

                info_arret.append("Diamnadio");
                aller1.append("07h40");
                retour1.append("07h40");
                aller2.append("11h30");
                retour2.append("11h30");
                aller3.append("14h10");
                retour3.append("14h10");
                aller4.append("16h20");
                retour4.append("16h20");

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
                myDialog.show();


            }
        });
    }
}
