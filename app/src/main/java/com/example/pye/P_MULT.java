package com.example.pye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class P_MULT extends AppCompatActivity {

    Button btn_Calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__mult);
        btn_Calc = (Button) findViewById(R.id.btn_Calcular_MULT);
        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView TV = (TextView) findViewById(R.id.tv_MULT);
                try {
                    EditText IN = (EditText) findViewById(R.id.editText_MULT);
                    String[] T = IN.getText().toString().toString().replaceAll(" ","").split(",");

                    BigDecimal BD = new BigDecimal("1");
                    int Resultado = 1;
                    for (String TXT : T) {
                        //Resultado *= Integer.parseInt(TXT);
                        BD = BD.multiply(new BigDecimal(TXT));
                    }
                    TV.setText("El producto es: " + BD.toString());
                } catch (Exception E) {
                    Toast.makeText(getApplicationContext(), "Solo Introducir numeros\n" + E.getClass(), Toast.LENGTH_SHORT).show();
                    TV.setText("");
                }
            }
        });
    }
}
