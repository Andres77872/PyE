package com.example.pye.Tema7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Tema_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_7);
        ((Button) findViewById(R.id.btn_T7_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Intervalo = ((EditText) findViewById(R.id.txtV_T7_Intervalo)).getText().toString();
                    if (Intervalo.isEmpty()) {
                        String DatosRAW[] = ((EditText) findViewById(R.id.txtV_T7_Entrada)).getText().toString().split(",");
                        double Rango = 0.0, DMedia = 0.0, DEstandar = 0.0, Varianza = 0.0, Promedio = 0.0;

                        double Datos[] = new double[DatosRAW.length];

                        for (int i = 0; i < Datos.length; i++) {
                            Datos[i] = Double.parseDouble(DatosRAW[i]);
                            Promedio += Datos[i];
                        }
                        Promedio /= Datos.length;

                        Arrays.sort(Datos);

                        for (int i = 0; i < Datos.length; i++) {
                            double VarTMP = Datos[i] - Promedio;
                            DMedia += Math.abs(VarTMP);
                            Varianza += Math.pow(VarTMP, 2);
                        }

                        DMedia /= Datos.length;
                        Varianza /= Datos.length;
                        DEstandar = Math.sqrt(Varianza);
                        Rango = Datos[Datos.length - 1] - Datos[0];

                        ((TextView) findViewById(R.id.lbl_T7_Rango)).setText("El rango es: " + Rango);
                        ((TextView) findViewById(R.id.lbl_T7_DesviacionEstandar)).setText("La desviacion estandar es: " + ((int) (DEstandar * 1000)) / 1000.0);
                        ((TextView) findViewById(R.id.lbl_T7_DesviacionMedia)).setText("La desviacion media es: " + ((int) (DMedia * 1000)) / 1000.0);
                        ((TextView) findViewById(R.id.lbl_T7_Varianza)).setText("La varianza es: " + ((int) (Varianza * 1000)) / 1000.0);
                    } else {
                        String Datos[] = ((EditText) findViewById(R.id.txtV_T7_Entrada)).getText().toString().split(",");
                        double CantidadClases = Double.parseDouble(Intervalo);

                        ArrayList<double[]> Clases = new ArrayList<>();

                        int CantidadDatos = Datos.length, Amplitud = 0;

                        int[] DatosINT = new int[Datos.length];

                        for (int i = 0; i < Datos.length; i++) {
                            DatosINT[i] = Integer.parseInt(Datos[i]);
                        }
                        Arrays.sort(DatosINT);
                        Amplitud = (int) Math.ceil((DatosINT[DatosINT.length - 1] - DatosINT[0] + 1) / CantidadClases);
                        //System.out.println(Amplitud);
                        for (int i = 0; i < CantidadClases; i++) {
                            int Li = (Amplitud * i) + DatosINT[0], Ls = (Amplitud * (i + 1)) + DatosINT[0];
                            Clases.add(new double[]{Li, Ls, (Li + Ls) / 2.0, 0, 0});
                        }
                        for (int D : DatosINT) {
                            for (int i = 0; i < CantidadClases; i++) {
                                int Li = (int) Clases.get(i)[0], Ls = (int) Clases.get(i)[1];
                                //System.out.println(Li + " : " + Ls);
                                //System.out.println(D+" : "+Li+" : "+Ls);
                                if (Li <= D && Ls > D) {
                                    Clases.get(i)[3]++;
                                }
                            }
                        }

                        double Promedio = 0.0;
                        for (double[] i : Clases) {
                            Promedio += i[3] * i[2];
                        }
                        Promedio /= (double) DatosINT.length;

                        double media = 0.0, estandar = 0.0, varianza = 0.0,Rango = 0.0;

                        for (double[] i : Clases) {
                            media += i[3] * Math.abs(i[2] - Promedio);
                            varianza += i[3] * Math.pow(i[2] - Promedio, 2);
                        }
                        media /= (double) DatosINT.length;
                        varianza /= (double) DatosINT.length;
                        estandar = Math.sqrt(varianza);

                        Rango = DatosINT[DatosINT.length - 1] - DatosINT[0];
                        ((TextView) findViewById(R.id.lbl_T7_Rango)).setText("El rango es: " + Rango);
                        ((TextView) findViewById(R.id.lbl_T7_DesviacionEstandar)).setText("La desviacion estandar es: " + ((int) (estandar * 1000)) / 1000.0);
                        ((TextView) findViewById(R.id.lbl_T7_DesviacionMedia)).setText("La desviacion media es: " + ((int) (media * 1000)) / 1000.0);
                        ((TextView) findViewById(R.id.lbl_T7_Varianza)).setText("La varianza es: " + ((int) (varianza * 1000)) / 1000.0);
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}
