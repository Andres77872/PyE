package com.example.pye.Tema11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

public class Tema_11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_11);

        ((Button) findViewById(R.id.btn_T11_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Datos = ((EditText) findViewById(R.id.edt_T11_Entrada)).getText().toString().split(",");
                String Busqueda = ((EditText) findViewById(R.id.edt_T11_Busqueda)).getText().toString();
                int max = 0;

                for (String i : Datos) {
                    String S[] = i.split(";");
                    max += Integer.parseInt(S[1]);
                }

                int C = -1;

                for (int i = 0; i < Datos.length; i++) {
                    String S[] = Datos[i].split(";");
                    if (Busqueda.equals(S[0])) {
                        C = Integer.parseInt(S[1]);
                    }
                }
                if (C == -1) {
                    ((TextView) findViewById(R.id.lbl_T11_Saldia)).setText(String.format("Probabilidad = 0"));
                } else {
                    ((TextView) findViewById(R.id.lbl_T11_Saldia)).setText("Probabilidad = "+ ((double) C / max));
                }
            }
        });

    }
}
