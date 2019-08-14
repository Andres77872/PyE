package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class P_AD extends AppCompatActivity {

    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__ad);
        btn_Calc = (Button) findViewById(R.id.btn_Calcular_AD);
        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView TV = (TextView) findViewById(R.id.tv_AD);
                try {
                    EditText IN = (EditText) findViewById(R.id.editText_AD);
                    String[] T = IN.getText().toString().replaceAll(" ","").split(",");

                    double Resultado = 0;
                    for (String TXT : T) {
                        Resultado += Double.parseDouble(TXT);
                    }
                    TV.setText("La suma es: " + Resultado);
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "Solo Introducir numeros\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                    TV.setText("");
                }
            }
        });
    }
}
