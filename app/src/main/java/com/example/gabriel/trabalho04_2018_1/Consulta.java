package com.example.gabriel.trabalho04_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ProgressDialog;

import java.util.List;

import model.Veiculo;
import network.iRetroFitFipe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.String.valueOf;

public class Consulta extends AppCompatActivity {

    Button btConsulta, btLimpar;
    AutoCompleteTextView etMarca, etAno, etModelo;
    TextView tvValor;
    RadioGroup rg;
    RadioButton rbCarro, rbMoto, rbCaminhao;

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        dialog = new ProgressDialog(Consulta.this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);


        iRetroFitFipe githubUser = iRetroFitFipe.retrofit.create(iRetroFitFipe.class);
        final Call<List<Veiculo>> call = githubUser.getMarcas("carros");
        dialog.show();
        call.enqueue(new Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {
                if(dialog.isShowing())
                    dialog.dismiss();
                List<Veiculo> lista = response.body();
                for(Veiculo veiculo : lista){
                    Log.d("LLLUUUIIIZZZZ", veiculo.getModelo());
                }
            }

            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {

                if(dialog.isShowing())
                    dialog.dismiss();

                Toast.makeText(getBaseContext(),"Flaha : ",Toast.LENGTH_LONG).show();

            }
        });
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        btConsulta = findViewById(R.id.btConsulta);
        btLimpar = findViewById(R.id.btLimpar);


        rg = findViewById(R.id.radioGroup);

        tvValor = findViewById(R.id.tvValor);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, MARCAS);
        AutoCompleteTextView textView = findViewById(R.id.etMarca);
        textView.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, MODELOS);
        AutoCompleteTextView textView2 = (AutoCompleteTextView)
                findViewById(R.id.etModelo);
        textView.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ANOS);
        AutoCompleteTextView textView3 = (AutoCompleteTextView)
                findViewById(R.id.etAno);
        textView.setAdapter(adapter3);

        btConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tipo;

                tipo = valueOf(rg.getCheckedRadioButtonId());

                if (tipo == "1"){
                    Toast.makeText(getApplicationContext(), "Carro", Toast.LENGTH_SHORT);
                }
                if (tipo == "2"){
                    Toast.makeText(getApplicationContext(), "Moto", Toast.LENGTH_SHORT);
                }
                if (tipo == "3"){
                    Toast.makeText(getApplicationContext(), "Caminhão", Toast.LENGTH_SHORT);
                }else{

                }
            }
        });
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
