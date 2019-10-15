package com.example.pye.Tema7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pye.R;

import java.util.Arrays;

public class Tema_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_7);
        ((Button) findViewById(R.id.btn_T7_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

            }
        });
    }
}
