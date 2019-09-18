package com.example.pye.Tema2.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pye.R;

import java.util.ArrayList;

public class P_T2_Aleatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__t2__aleatorio);

        ListView listaRES, ListaIN;
        final ArrayAdapter<String> adaptador, Resultados;

        listaRES = (ListView) findViewById(R.id.lst_T2_Aleatorio_Res);
        ListaIN = (ListView) findViewById(R.id.lst_T2_Aleatorio_IN);

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        Resultados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        final ArrayList<String[]> DATA = new ArrayList<>();
        final TextView TV_IN = (TextView) findViewById(R.id.T2_lbl_IN);
        final TextView TV_RES = (TextView) findViewById(R.id.T2_lbl_RES);


        ((Button) findViewById(R.id.btn_T2_SN_Generar_Aleatorio)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int N = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_N_Aleatorio)).getText().toString());
                adaptador.clear();
                Resultados.clear();
                DATA.clear();
                double A_IN = 0, B_IN = 0, C_IN = 0;


                for (int i = 0; i < N; i++) {
                    double R = Math.random();
                    String L = (R < 0.1) ? "A" : (R < 0.3) ? "B" : "C";
                    DATA.add(new String[]{String.valueOf(i), L});
                    adaptador.add(String.valueOf(i) + " : " + L);
                    switch (L) {
                        case "A":
                            A_IN++;
                            break;
                        case "B":
                            B_IN++;
                            break;
                        case "C":
                            C_IN++;
                            break;
                    }
                }

                TV_IN.setText("A=" + (A_IN == 0 ? "0" : (int) ((A_IN / N) * 100)) + " B=" + (B_IN == 0 ? "0" : (int) ((B_IN / N) * 100)) + " C=" + (C_IN == 0 ? "0" : (int) ((C_IN / N) * 100)));

            }
        });

        ((Button) findViewById(R.id.T2_btn_Aleatorio)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int n = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_n_Aleatorio)).getText().toString());
                double A_RES = 0, B_RES = 0, C_RES = 0;
                ArrayList<String[]> _DATA = (ArrayList<String[]>) DATA.clone();
                Resultados.clear();
                for (int i = 0; i < n; i++) {
                    int R = (int) (Math.random() * _DATA.size());
                    String L = _DATA.get(R)[1];
                    Resultados.add(_DATA.get(R)[0] + " : " + L);
                    _DATA.remove(R);
                    switch (L) {
                        case "A":
                            A_RES++;
                            break;
                        case "B":
                            B_RES++;
                            break;
                        case "C":
                            C_RES++;
                            break;
                    }
                }
                TV_RES.setText("A=" + (A_RES == 0 ? "0" : (int) ((A_RES / n) * 100)) + " B=" + (B_RES == 0 ? "0" : (int) ((B_RES / n) * 100)) + " C=" + (C_RES == 0 ? "0" : (int) ((C_RES / n * 100))));
            }
        });
        ((Button) findViewById(R.id.T2_btn_Sistematico)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int N = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_N_Aleatorio)).getText().toString());
                final int n = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_n_Aleatorio)).getText().toString());
                double A_RES = 0, B_RES = 0, C_RES = 0;
                int I = N / n, Rnd = (int) (Math.random() * I);
                ArrayList<String[]> _DATA = (ArrayList<String[]>) DATA.clone();
                Resultados.clear();
                for (int i = 0; i < n; i++) {
                    int D = Rnd + (I * i);
                    String L = _DATA.get(D)[1];
                    Resultados.add(_DATA.get(D)[0] + " : " + L);
                    switch (L) {
                        case "A":
                            A_RES++;
                            break;
                        case "B":
                            B_RES++;
                            break;
                        case "C":
                            C_RES++;
                            break;
                    }
                }
                TV_RES.setText("A=" + (A_RES == 0 ? "0" : (int) ((A_RES / n) * 100)) + " B=" + (B_RES == 0 ? "0" : (int) ((B_RES / n) * 100)) + " C=" + (C_RES == 0 ? "0" : (int) ((C_RES / n * 100))));

            }
        });
        ((Button) findViewById(R.id.T2_btn_Estratificado)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int N = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_N_Aleatorio)).getText().toString());
                final int n = Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_n_Aleatorio)).getText().toString());
                double A_RES = 0, B_RES = 0, C_RES = 0;
                ArrayList<String[]> _DATA = (ArrayList<String[]>) DATA.clone(),
                        DATA_A = new ArrayList<>(),
                        DATA_B = new ArrayList<>(),
                        DATA_C = new ArrayList<>();
                Resultados.clear();
                for (int i = 0; i < N; i++) {
                    String L = _DATA.get(i)[1];
                    switch (L) {
                        case "A":
                            DATA_A.add(_DATA.get(i));
                            break;
                        case "B":
                            DATA_B.add(_DATA.get(i));
                            break;
                        case "C":
                            DATA_C.add(_DATA.get(i));
                            break;
                    }
                }
                double DA = _DATA.size(),
                        DAZ = DATA_A.size(),
                        DBZ = DATA_B.size(),
                        DCZ = DATA_C.size();
                int Ai = (int) ((DAZ / DA) * n),
                        Bi = (int) ((DBZ / DA) * n),
                        Ci = (int) ((DCZ / DA) * n);

                for (int i = 0; i < Ai; i++) {
                    int R = (int) (Math.random() * DATA_A.size());
                    String L = DATA_A.get(R)[1];
                    Resultados.add(DATA_A.get(R)[0] + " : " + L);
                    DATA_A.remove(R);
                    A_RES++;
                }
                for (int i = 0; i < Bi; i++) {
                    int R = (int) (Math.random() * DATA_B.size());
                    String L = DATA_B.get(R)[1];
                    Resultados.add(DATA_B.get(R)[0] + " : " + L);
                    DATA_B.remove(R);
                    B_RES++;
                }
                for (int i = 0; i < Ci; i++) {
                    int R = (int) (Math.random() * DATA_C.size());
                    String L = DATA_C.get(R)[1];
                    Resultados.add(DATA_C.get(R)[0] + " : " + L);
                    DATA_C.remove(R);
                    C_RES++;
                }

                TV_RES.setText("A=" + (A_RES == 0 ? "0" : (int) ((A_RES / n) * 100)) + " B=" + (B_RES == 0 ? "0" : (int) ((B_RES / n) * 100)) + " C=" + (C_RES == 0 ? "0" : (int) ((C_RES / n * 100))));

            }
        });
        ((Button) findViewById(R.id.T2_btn_Conglomerado)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ListaIN.setAdapter(adaptador);
        listaRES.setAdapter(Resultados);

    }
}
