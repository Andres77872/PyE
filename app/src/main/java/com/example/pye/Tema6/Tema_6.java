package com.example.pye.Tema6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pye.R;

public class Tema_6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_6);

        ((Button) findViewById(R.id.btn_T6_Calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String[] Dato1 = ((EditText) findViewById(R.id.txtV_T6_Entrada1)).getText().toString().split(","),
                            Dato2 = ((EditText) findViewById(R.id.txtV_T6_Entrada2)).getText().toString().split(";");
                    double P2 = Double.parseDouble(Dato1[0]) * Double.parseDouble(Dato1[1]), P1 = P2;
                    for (String D : Dato2) {
                        String DD[] = D.split(",");
                        P2 += Double.parseDouble(DD[0]) * Double.parseDouble(DD[1]);
                    }
                    P1 /= P2;
                    ((TextView) findViewById(R.id.lbl_T6_Salida)).setText("P(A|B) = ".concat(String.valueOf(P1 * 100)));
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "ERROR:\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
