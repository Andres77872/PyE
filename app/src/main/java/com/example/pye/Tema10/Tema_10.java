package com.example.pye.Tema10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

import java.util.ArrayList;
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

                int[] DatosINT = new int[Entrada.length];

                for (int i = 0; i < Entrada.length; i++) {
                    DatosINT[i] = Integer.parseInt(Entrada[i]);
                }
                Arrays.sort(DatosINT);

                ArrayList<int[]> DT = new ArrayList<>();

                DT.add(new int[]{DatosINT[0], 1});

                for (int i = 1; i < DatosINT.length; i++) {
                    boolean NW = true;
                    for (int j = 0; j < DT.size(); j++) {
                        if (DT.get(j)[0] == DatosINT[i]) {
                            DT.get(j)[1]++;
                            NW = false;
                        }
                    }
                    if (NW) {
                        DT.add(new int[]{DatosINT[i], 1});
                    }
                }


                double Media = 0.0, Moda = 0.0, N = DatosINT.length, m2 = 0.0, m4 = 0.0;
                for (int i : DatosINT) {
                    Media += i;
                }
                Media /= DatosINT.length;
                Arrays.sort(Entrada);


                int MD[][] = new int[DT.size()][2];
                for (int i = 0; i < DT.size(); i++) {
                    MD[i][0] = DT.get(i)[1];
                    MD[i][1] = DT.get(i)[0];
                }

                for (int i = 0; i < MD.length; i++) {
                    for (int j = 0; j < MD.length; j++) {
                        if (MD[i][0] > MD[j][0]) {
                            int[] tmp = MD[j];
                            MD[j] = MD[i];
                            MD[i] = tmp;
                        }
                    }
                }


                Moda = MD[0][1];

                System.out.println(Media + " : " + Moda + " =================================================");

                for (int i = 0; i < MD.length; i++) {
                    String[] S = new String[]{String.valueOf(MD[i][0]), String.valueOf(MD[i][1])};
                    m2 += Math.pow((Integer.parseInt(S[1]) - Media), 2) * Integer.parseInt(S[0]);
                    m4 += Math.pow((Integer.parseInt(S[1]) - Media), 4) * Integer.parseInt(S[0]);
                }
                m2 /= N;
                m4 /= N;
                ((TextView) findViewById(R.id.lbl_T10_S)).setText(String.format("Sesgo = %s", (Media - Moda) / Math.sqrt(m2)));
                ((TextView) findViewById(R.id.lbl_T10_K)).setText(String.format("Curtosis = %s", (m4 / Math.pow(m2, 2)) - 3));
                System.out.println(Media);
                System.out.println(Moda);
                System.out.println(Arrays.deepToString(MD));
            }
        });
    }
}
