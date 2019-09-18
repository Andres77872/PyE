package com.example.pye.Tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pye.R;
import com.example.pye.Tema1.act.P_MULT;
import com.example.pye.Tema2.act.P_T2_Aleatorio;
import com.example.pye.Tema2.act.P_T2_TamMuestra;

public class Tema_2 extends AppCompatActivity {

    Button btn_TamMuestra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_2);
        btn_TamMuestra = (Button) findViewById(R.id.btn_T2_TamMuestra);
        btn_TamMuestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw = new Intent(getApplicationContext(), P_T2_TamMuestra.class);
                startActivity(vw);
            }
        });

        ((Button)findViewById(R.id.btn_T2_AleatorioSimple)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vw = new Intent(getApplicationContext(), P_T2_Aleatorio.class);
                startActivity(vw);
            }
        });

    }
}
