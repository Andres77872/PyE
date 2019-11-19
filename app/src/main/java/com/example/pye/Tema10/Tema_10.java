package com.example.pye.Tema10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

import java.util.Arrays;

public class Tema_10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_10);
        ((Button) findViewById(R.id.btn_T10_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Entrada = ((EditText) findViewById(R.id.edt_T10_Entrada)).getText().toString().split(",");
                double Media = 0.0, Moda = 0.0, N = 0.0, m2 = 0.0, m4 = 0.0;
                for (int i = 0; i < Entrada.length; i++) {
                    String[] S = Entrada[i].split(";");
                    Entrada[i] = S[1] + ";" + S[0];
                    Media += Integer.parseInt(S[0]) * Integer.parseInt(S[1]);
                    N += Integer.parseInt(S[1]);
                }
                Media /= N;
                Arrays.sort(Entrada);
                Moda = Integer.parseInt(Entrada[Entrada.length - 1].split(";")[1]);
                for (int i = 0; i < Entrada.length; i++) {
                    String[] S = Entrada[i].split(";");
                    m2 += Math.pow((Integer.parseInt(S[1]) - Media), 2) * Integer.parseInt(S[0]);
                    m4 += Math.pow((Integer.parseInt(S[1]) - Media), 4) * Integer.parseInt(S[0]);
                }
                m2 /= N;
                m4 /= N;
                ((TextView) findViewById(R.id.lbl_T10_S)).setText(String.format("Sesgo = %s", (Media - Moda) / Math.sqrt(m2)));
                ((TextView) findViewById(R.id.lbl_T10_K)).setText(String.format("Curtosis = %s", (m4 / Math.pow(m2, 2)) - 3));
                System.out.println(Media);
                System.out.println(Moda);
                System.out.println(Arrays.toString(Entrada));
            }
        });
    }
}
