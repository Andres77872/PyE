package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pye.Tema1.Tema_1;
import com.example.pye.Tema2.Tema_2;

public class MainActivity extends AppCompatActivity {

    Button btn_Tema1,btn_Tema2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Tema1=(Button) findViewById(R.id.btn_Tema_1);
        btn_Tema2=(Button) findViewById(R.id.btn_Tema_2);
        btn_Tema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(), Tema_1.class);
                startActivity(vw);
            }
        });
        btn_Tema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw=new Intent(getApplicationContext(), Tema_2.class);
                startActivity(vw);
            }
        });
    }

}
