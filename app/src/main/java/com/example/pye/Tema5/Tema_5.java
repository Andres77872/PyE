package com.example.pye.Tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pye.R;

public class Tema_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema5);

        ((Button) findViewById(R.id.btn_T5_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Entrada[] = ((EditText) findViewById(R.id.edt_T5_Entrada)).getText().toString().split(",");
                    double Mult = 1, MG = 0.0, MA = 0.0;

                    for (int i = 0; i < Entrada.length; i++) {
                        Mult *= Integer.parseInt(Entrada[i]);
                        MA += (1.0 / Integer.parseInt(Entrada[i]));
                    }

                    MG = Math.pow(Mult, 1.0 / Entrada.length);
                    MA = Entrada.length / MA;

                    ((TextView) findViewById(R.id.lbl_T5_MG)).setText("La media geomtrica es: " + MG);
                    ((TextView) findViewById(R.id.lbl_T5_MA)).setText("La media armonica es: " + MA);
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "ERROR:\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        ((Button) findViewById(R.id.btn_T5_CalcularMP)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Entrada[] = ((EditText) findViewById(R.id.edt_T5_EntradaMP)).getText().toString().split(",");
                    double Suma1 = 0.0, Suma2 = 0.0, MP = 0.0;

                    for (int i = 0; i < Entrada.length; i++) {
                        String[] E = Entrada[i].split(";");
                        double x = Double.parseDouble(E[0]), p = Double.parseDouble(E[1]);
                        Suma1 += x * p;
                        Suma2 += p;
                    }

                    if (Suma2 > 100) {
                        Toast.makeText(getApplicationContext(), "El porcentaje no puede ser mayor a 100", Toast.LENGTH_SHORT).show();
                    } else {

                        ((TextView) findViewById(R.id.lbl_T5_MP)).setText("La media ponderada es: " + (Suma1 / Suma2));
                    }
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "ERROR:\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
