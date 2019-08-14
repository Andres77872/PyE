package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class FACT extends AppCompatActivity {

    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);
        btn_Calc = (Button) findViewById(R.id.btn_Calcular_FACT);
        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView TV = (TextView) findViewById(R.id.tv_FACT);
                try {
                    EditText IN = (EditText) findViewById(R.id.editText_FACT);
                    BigInteger BG=new BigInteger("1");
                    long T = Integer.parseInt(IN.getText().toString().trim());
                    if (T < 0) {
                        Toast.makeText(getApplicationContext(), "Introducir solo numeros enteros positivos", Toast.LENGTH_SHORT).show();
                        TV.setText("");
                    } else {
                        int Resultado = 1;
                        if (T != 0 && T != 1) {
                            for (int i = 1; i <= T; i++) {
                                //Resultado *= i;
                                BG=BG.multiply(new BigInteger(i+""));
                            }
                        }
                        TV.setText("El factorial es: " + BG.toString());
                    }
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "Solo Introducir numeros enteros\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                    TV.setText("");
                }
            }
        });
    }
}
