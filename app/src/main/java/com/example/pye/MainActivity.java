package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pye.Tema1.Tema_1;
import com.example.pye.Tema2.Tema_2;
import com.example.pye.Tema3.Tema_3;
import com.example.pye.Tema4.Tema_4;
import com.example.pye.Tema5.Tema_5;
import com.example.pye.Tema6.Tema_6;
import com.example.pye.Tema7.Tema_7;
import com.example.pye.Tema8.Tema_8;

public class MainActivity extends AppCompatActivity {

    Button btn_Tema1, btn_Tema2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Tema1 = (Button) findViewById(R.id.btn_Tema_1);
        btn_Tema2 = (Button) findViewById(R.id.btn_Tema_2);
        btn_Tema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw = new Intent(getApplicationContext(), Tema_1.class);
                startActivity(vw);
            }
        });
        btn_Tema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw = new Intent(getApplicationContext(), Tema_2.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_3.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_4.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_5.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_6)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_6.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_7)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_7.class);
                startActivity(vw);
            }
        });
        ((Button) findViewById(R.id.btn_Tema_8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vw = new Intent(getApplicationContext(), Tema_8.class);
                startActivity(vw);
            }
        });
    }

}
