package com.example.pye.Tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pye.Tema1.act.FACT;
import com.example.pye.Tema1.act.P_AD;
import com.example.pye.Tema1.act.P_MULT;
import com.example.pye.R;

public class Tema_1 extends AppCompatActivity {

    Button btn_mult,btn_adt,btn_fact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_3);

        btn_mult=(Button) findViewById(R.id.btn_Multi);
        btn_adt=(Button) findViewById(R.id.btn_Add);
        btn_fact=(Button) findViewById(R.id.btn_Factorial);
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(), P_MULT.class);
                startActivity(vw);
            }
        });
        btn_adt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(), P_AD.class);
                startActivity(vw);
            }
        });
        btn_fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(), FACT.class);
                startActivity(vw);
            }
        });


    }
}
