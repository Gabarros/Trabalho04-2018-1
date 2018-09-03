package com.example.gabriel.trabalho04_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Consulta extends AppCompatActivity {

    Button btConsulta, btLimpar;
    AutoCompleteTextView etMarca, etAno, etModelo;
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
        etAno = findViewById(R.id.etModelo);
        etModelo = findViewById(R.id.etModelo);

        rg = findViewById(R.id.radioGroup);

        tvValor = findViewById(R.id.tvValor);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, MARCAS);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.etMarca);
        textView.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, MODELOS);
        AutoCompleteTextView textView2 = (AutoCompleteTextView)
                findViewById(R.id.etModelo);
        textView.setAdapter(adapter);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ANOS);
        AutoCompleteTextView textView3 = (AutoCompleteTextView)
                findViewById(R.id.etAno);
        textView.setAdapter(adapter);
    }

    private static final String[] MARCAS = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    private static final String[] MODELOS = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    private static final String[] ANOS = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
}
