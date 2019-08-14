package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_mult,btn_adt,btn_fact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_mult=(Button) findViewById(R.id.btn_Multi);
        btn_adt=(Button) findViewById(R.id.btn_Add);
        btn_fact=(Button) findViewById(R.id.btn_Factorial);
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(),P_MULT.class);
                startActivity(vw);
            }
        });
        btn_adt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(),P_AD.class);
                startActivity(vw);
            }
        });
        btn_fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(),FACT.class);
                startActivity(vw);
            }
        });
    }

}
