package com.example.pye.Tema9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pye.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tema_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_9);

        ((Button) findViewById(R.id.btn_T9_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String[] Entrada = ((EditText) findViewById(R.id.edt_T9_Entrada)).getText().toString().split(",");
                    double Mx = 0.0, My = 0.0, Mx2 = 0.0, Mxy = 0.0;

                    Arrays.sort(Entrada);

                    ArrayList<Entry> values = new ArrayList<>();
                    LineChart GR = findViewById(R.id.chart_T9_Grafica);
                    GR.setTouchEnabled(true);
                    GR.setPinchZoom(true);
                    int x = 0;
                    for (String Dato : Entrada) {
                        String[] D = Dato.split(";");
                        values.add(new Entry(Float.parseFloat(D[0]), Float.parseFloat(D[1])));
                        x++;
                        Mx += Integer.parseInt(D[0]);
                        My += Integer.parseInt(D[1]);
                        Mx2 += Math.pow(Integer.parseInt(D[0]), 2);
                        Mxy += Integer.parseInt(D[0]) * Integer.parseInt(D[1]);
                    }

                    LineDataSet lineDataSet = new LineDataSet(values, "DATOS");
                    lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
                    lineDataSet.setHighlightEnabled(true);
                    lineDataSet.setLineWidth(2);
                    //lineDataSet.setColor(getColor("defaultBlue"));
                    //lineDataSet.setCircleColor(getColor("defaultOrange"));
                    lineDataSet.setCircleRadius(6);
                    lineDataSet.setCircleHoleRadius(3);
                    lineDataSet.setDrawHighlightIndicators(true);
                    lineDataSet.setHighLightColor(Color.RED);
                    lineDataSet.setValueTextSize(12);
                    //lineDataSet.setValueTextColor(getColor("primaryDark"));

                    LineData lineData = new LineData(lineDataSet);

                    GR.getDescription().setText("Recta de regresion");
                    GR.getDescription().setTextSize(12);
                    GR.setDrawMarkers(true);
                    GR.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
                    GR.animateY(1000);
                    GR.getXAxis().setGranularityEnabled(true);
                    GR.getXAxis().setGranularity(1.0f);
                    GR.getXAxis().setLabelCount(lineDataSet.getEntryCount());
                    GR.setData(lineData);


                    int N = Entrada.length;

                    double m = ((N * Mxy) - (Mx * My)) / ((N * Mx2) - Math.pow(Mx, 2)),
                            b = ((My * Mx2) - (Mx * Mxy)) / ((N * Mx2) - Math.pow(Mx, 2));

                    ((TextView) findViewById(R.id.lbl_T9_m)).setText(String.format("m = %s", ((int) (m * 1000)) / 1000.0));
                    ((TextView) findViewById(R.id.lbl_T9_b)).setText(String.format("b = %s", ((int) (b * 1000)) / 1000.0));

                    Mx /= N;
                    My /= N;

                    double Sxy = 0.0, Sx = 0.0, Sy = 0.0;

                    for (String Dato : Entrada) {
                        String[] D = Dato.split(";");
                        Sxy += (Integer.parseInt(D[0]) - Mx) * (Integer.parseInt(D[1]) - My);
                        Sx += Math.pow((Integer.parseInt(D[0]) - Mx), 2);
                        Sy += Math.pow((Integer.parseInt(D[1]) - My), 2);
                    }

                    Sxy /= N;
                    Sx /= N;
                    Sy /= N;

                    ((TextView) findViewById(R.id.lbl_T9_Pearson)).setText(String.format("R = %s", ((int) (((Sxy / (Math.sqrt(Sx) * Math.sqrt(Sy)))) * 1000)) / 1000.0));
                } catch (Exception E) {
                    E.printStackTrace();
                    Toast.makeText(getApplicationContext(), "ERROR:\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
