package com.example.gabriel.trabalho04_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Consulta extends AppCompatActivity {

    Button btConsulta, btLimpar;
    EditText etMarca, etAno, etModelo;
    TextView tvValor;
    RadioGroup rg;
    RadioButton rbCarro, rbMoto, rbCaminha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        btConsulta = findViewById(R.id.btConsulta);
        btLimpar = findViewById(R.id.btLimpar);

        etMarca = findViewById(R.id.etMarca);
        etAno = findViewById(R.id.etAno);
        etModelo = findViewById(R.id.etModelo);

        rg = findViewById(R.id.radioGroup);

        tvValor = findViewById(R.id.tvValor);
    }
}
