package com.example.pye.Tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pye.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tema_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_4);
        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ((Button) findViewById(R.id.btn_T4_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Datos[] = ((EditText) findViewById(R.id.txtV_T4_Entrada)).getText().toString().split(",");
                double CantidadClases= Double.parseDouble(((EditText) findViewById(R.id.txtV_T4_CantidadIntervalos)).getText().toString());

                ArrayList<int[]> Clases = new ArrayList<>();

                //double CantidadClases = 10;
                //String Datos[] = new String[98];


                /*for (int i = 0; i < Datos.length; i++) {
                    Datos[i] = String.valueOf((int) ((Math.random() * 145) + 145));
                    System.out.println(Datos[i]);
                }*/

                int CantidadDatos = Datos.length, Amplitud = 0;

                int[] DatosINT = new int[Datos.length];

                for (int i = 0; i < Datos.length; i++) {
                    DatosINT[i] = Integer.parseInt(Datos[i]);
                }
                Arrays.sort(DatosINT);
                Amplitud = (int) Math.ceil((DatosINT[DatosINT.length - 1] - DatosINT[0]) / CantidadClases);

                for (int i = 0; i < CantidadClases; i++) {
                    int Li = (Amplitud * i) + DatosINT[0], Ls = (Amplitud * (i + 1)) + DatosINT[0];
                    Clases.add(new int[]{Li, Ls, ((Amplitud * i) + (Amplitud * (i + 1))) / 2, 0, 0});
                }

                for (int D : DatosINT) {
                    for (int i = 0; i < CantidadClases; i++) {
                        int Li = Clases.get(i)[0], Ls = Clases.get(i)[1];
                        //System.out.println(Li + " : " + Ls);
                        //System.out.println(D+" : "+Li+" : "+Ls);
                        if (Li <= D && Ls > D) {
                            Clases.get(i)[3]++;
                        }
                    }
                }

                double Promedio = 0.0, Mediana = 0.0, Moda = 0;
                int F = 0;
                int ClaseMax = -1, Max = -1;
                for (int i = 0; i < CantidadClases; i++) {
                    Promedio += Clases.get(i)[2] * Clases.get(i)[3];
                    if (Max < Clases.get(i)[3]) {
                        Max = Clases.get(i)[3];
                        ClaseMax = i;
                    }
                    F += Clases.get(i)[3];
                    Clases.get(i)[4] = F;
                }
                Promedio /= (double) Datos.length;

                //System.out.println(Clases.get(ClaseMax)[0] + " : " + Clases.get(ClaseMax - 1)[4] + " : " + Clases.get(ClaseMax)[3] + " : " + Amplitud);

                double d1 = 0.0, d2 = 0.0;
                if (ClaseMax > 0) {
                    Mediana = Clases.get(ClaseMax)[0] +
                            (((Datos.length / 2.0) - Clases.get(ClaseMax - 1)[4]) /
                                    Clases.get(ClaseMax)[3]) *
                                    (double) Amplitud;
                    d1 = Clases.get(ClaseMax)[3] - Clases.get(ClaseMax - 1)[3];
                } else {
                    Mediana = Clases.get(ClaseMax)[0] +
                            (((Datos.length / 2.0)) /
                                    Clases.get(ClaseMax)[3]) *
                                    (double) Amplitud;
                    d1 = Clases.get(ClaseMax)[3];
                }
                if (ClaseMax == CantidadClases - 1) {
                    d2 = Clases.get(ClaseMax)[3];
                }
                System.out.println(Clases.get(ClaseMax)[0] + " : " + d1 + " : " + " : " + d2 + " : " + Amplitud);
                Moda = Clases.get(ClaseMax)[0] + ((d1 / (d1 + d2)) * (double) Amplitud);
                ((TextView) findViewById(R.id.txtV_T4_Promedio)).setText("Promedio " + Promedio);
                ((TextView) findViewById(R.id.txtV_T4_Moda)).setText("Moda " + Moda);
                ((TextView) findViewById(R.id.txtV_T4_Media)).setText("Media " + Mediana);


                BarChart bchart = findViewById(R.id.chart1);

                ArrayList<BarEntry> yVals1 = new ArrayList<>();

                ArrayList<IBarDataSet> dataSets = new ArrayList<>();

                for (int i = 0; i < CantidadClases; i++) {
                    float val = Clases.get(i)[3];
                    yVals1.add(new BarEntry(i+1, val));


                }
                BarDataSet set1 = new BarDataSet(yVals1, "Marca de clase");
                set1.setColors(ColorTemplate.MATERIAL_COLORS);
                dataSets.add(set1);

                BarData data = new BarData(dataSets);

                data.setValueTextSize(10f);
                data.setBarWidth(0.9f);

                bchart.setFitBars(true);
                bchart.setData(data);


                adaptador.clear();
                adaptador.add("Rango\t\t\t\t\t\tMC\t\t\t\t\t\tf\t\t\t\t\t\tF");
                for (int i = 0; i < CantidadClases; i++) {
                    adaptador.add("("+Clases.get(i)[0]+","+Clases.get(i)[1]+")\t\t\t\t\t\t"+Clases.get(i)[2]+"\t\t\t\t\t\t"+Clases.get(i)[3]+"\t\t\t\t\t\t"+Clases.get(i)[4]);
                }



                ((ListView)findViewById(R.id.lst)).setAdapter(adaptador);

            }
        });

    }
}
