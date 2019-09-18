package com.example.pye.Tema3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Tema_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_3_1);

        ((Button) findViewById(R.id.btn_T3_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Entrada[] = ((EditText) findViewById(R.id.txtV_T3_Entrada)).getText().toString().split(",");

                Arrays.sort(Entrada);

                ArrayList<String[]> Datos = new ArrayList<>();

                double Promedio = 0.0;
                double Media = (Entrada.length % 2 == 1) ?
                        Double.parseDouble(Entrada[(Entrada.length / 2)]) :
                        (Double.parseDouble(Entrada[(Entrada.length / 2)]) + Double.parseDouble(Entrada[(Entrada.length / 2) -1])) / 2.0;
                String Moda = "";


                for (String D : Entrada) {
                    boolean Encontrado = false;
                    for (int j = 0; j < Datos.size(); j++) {
                        if (Datos.get(j)[0].equals(D)) {
                            Datos.get(j)[1] = String.valueOf(Integer.parseInt(Datos.get(j)[1]) + 1);
                            Encontrado = true;
                            break;
                        }
                    }
                    if (!Encontrado) {
                        Datos.add(new String[]{D, "1"});
                    }
                    Promedio += Double.parseDouble(D);
                }

                if (Datos.size() == Entrada.length) {
                    Moda = "No hay moda";
                } else {

                    int Max = -1;
                    for (int i = 0; i < Datos.size(); i++) {
                        if (Max < Integer.parseInt(Datos.get(i)[1])) {
                            Max = Integer.parseInt(Datos.get(i)[1]);
                        }
                    }

                    int T = 0;
                    for (String D[] : Datos) {
                        if (Integer.parseInt(D[1]) == Max) {
                            Moda += D[0] + ",";
                            T++;
                        }
                    }
                    if (T == Datos.size()) {
                        Moda = "No hay moda";
                    }
                }
                Promedio /= Entrada.length;
                ((TextView) findViewById(R.id.txtV_T3_Media)).setText(String.valueOf(Media));
                ((TextView) findViewById(R.id.txtV_T3_Moda)).setText(Moda);
                ((TextView) findViewById(R.id.txtV_T3_Promedio)).setText(String.valueOf(Promedio));
            }
        });

    }
}
