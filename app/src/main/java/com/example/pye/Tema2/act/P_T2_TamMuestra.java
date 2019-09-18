package com.example.pye.Tema2.act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pye.R;
import com.example.pye.Tema1.Tema_1;

public class P_T2_TamMuestra extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] country = {"80%", "90%", "91%", "92%", "93%", "94%", "95%"};
    Double[] ZDef = {1.28, 1.65, 1.69, 1.75, 1.81, 1.88, 1.96};
    EditText edt_q;
    double Z = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p__t2__tam_muestra);

        Spinner spin = (Spinner) findViewById(R.id.T2_SP_Z);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        ((EditText) findViewById(R.id.T2_SP_edt_p)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0 && !s.toString().endsWith(".")) {
                    ((EditText) findViewById(R.id.T2_SP_edt_q)).setText(String.valueOf(1 - Double.parseDouble(s.toString())));
                }
            }
        });

        ((Button) findViewById(R.id.btn_T2_Calcular_TamMuestra)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((EditText) findViewById(R.id.T2_SP_edt_Resultado)).setText(String.valueOf(getTamMuestra(
                            Integer.parseInt(((EditText) findViewById(R.id.T2_SP_edt_N)).getText().toString()),
                            Z,
                            Double.parseDouble(((EditText) findViewById(R.id.T2_SP_edt_Error)).getText().toString()) / 100,
                            Double.parseDouble(((EditText) findViewById(R.id.T2_SP_edt_p)).getText().toString()) / 100,
                            Double.parseDouble(((EditText) findViewById(R.id.T2_SP_edt_q)).getText().toString()) / 100
                    )));
                } catch (NumberFormatException E) {
                    Toast.makeText(getApplicationContext(), "Complete todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });


        ((Button) findViewById(R.id.btn_T2_Calcular_CopiarTamMuestra)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.T2_SP_edt_Resultado)).getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", text);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Muestra copiada", Toast.LENGTH_LONG).show();
            }
        });

    }

    private int getTamMuestra(int N, double Z, double e, double p, double q) {
        double n = (Math.pow(Z, 2) * N * p * q) / (Math.pow(e, 2) * (N - 1) + (Math.pow(Z, 2) * p * q));
        return (int) n;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
        //EditText Error = (EditText) findViewById(R.id.T2_SP_edt_Error);
        //Spinner spin = (Spinner) findViewById(R.id.T2_SP_Z);
        //Error.setText(String.valueOf(100 - Integer.parseInt(country[position].replace("%", ""))));
        Z = ZDef[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
