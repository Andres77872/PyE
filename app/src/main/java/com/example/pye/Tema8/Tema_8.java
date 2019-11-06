package com.example.pye.Tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pye.R;

public class Tema_8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_8);

        ((Button) findViewById(R.id.btn_T8_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String[] Entrada = ((EditText) findViewById(R.id.edt_T8_Entrada)).getText().toString().split(",");
                    double Mx = 0.0, My = 0.0;
                    for (String Dato : Entrada) {
                        String[] D = Dato.split(";");
                        Mx += Integer.parseInt(D[0]);
                        My += Integer.parseInt(D[1]);
                    }
                    Mx /= Entrada.length;
                    My /= Entrada.length;

                    double Sxy = 0.0, Sx = 0.0, Sy = 0.0;

                    for (String Dato : Entrada) {
                        String[] D = Dato.split(";");
                        Sxy += (Integer.parseInt(D[0]) - Mx) * (Integer.parseInt(D[1]) - My);
                        Sx += Math.pow((Integer.parseInt(D[0]) - Mx), 2);
                        Sy += Math.pow((Integer.parseInt(D[1]) - My), 2);
                    }

                    Sxy /= Entrada.length;
                    Sx /= Entrada.length;
                    Sy /= Entrada.length;

                    ((TextView) findViewById(R.id.lbl_T8_Resultado)).setText(String.format("R = %s", ((int) (((Sxy / (Math.sqrt(Sx) * Math.sqrt(Sy)))) * 1000)) / 1000.0));
                }catch (Exception E){
                    Toast.makeText(getApplicationContext(), "ERROR:\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
