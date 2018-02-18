package com.reciclagem.reciclagem;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TelaProduto extends AppCompatActivity {

    ImageView fotoProduto;
    TextView nomeProduto;
    TextView valorProduto;
    Spinner spinnerHorario;
    Spinner spinnerDia;
    Spinner spinnerMes;
    Spinner spinnerAno;
    Button botaoReservar;

    String[] informations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_produto);

        //para garantir que a internet será acessada
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        Intent i = getIntent();
        informations = i.getStringArrayExtra("Produto");

        fotoProduto = (ImageView) findViewById(R.id.fotoProduto);
        nomeProduto = (TextView) findViewById(R.id.nomeProduto);
        valorProduto = (TextView) findViewById(R.id.valorProduto);

        spinnerHorario = (Spinner)findViewById(R.id.spinnerHorario);
        spinnerDia = (Spinner)findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner)findViewById(R.id.spinnerMes);
        spinnerAno = (Spinner)findViewById(R.id.spinnerAno);

        botaoReservar = (Button)findViewById(R.id.botaoReservar);
        botaoReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Picasso.with(this)
               .load(informations[2])
               .into(fotoProduto);
        fotoProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaProduto.this, Pop.class).putExtra("URL", informations[2]));
            }
        });

        nomeProduto.setText(informations[0]);
        nomeProduto.setTypeface(null, Typeface.BOLD);;
        valorProduto.setText(informations[1]);
        valorProduto.setTypeface(null, Typeface.BOLD);

        //ArrayList Spinner Horário

        List<String> listHorario = new ArrayList<String>();
        listHorario.add("Selecione um horário");
        listHorario.add("00:00");
        listHorario.add("02:00");
        listHorario.add("04:00");
        listHorario.add("06:00");
        listHorario.add("08:00");
        listHorario.add("10:00");
        listHorario.add("12:00");
        listHorario.add("14:00");
        listHorario.add("16:00");
        listHorario.add("18:00");


        ArrayAdapter<String> dataAdapterHorario = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listHorario);

        dataAdapterHorario.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerHorario.setAdapter(dataAdapterHorario);


        //ArrayList Spinner Dia

        List<String> listDia = new ArrayList<String>();
        listDia.add("Dia");
        listDia.add("01");listDia.add("02");listDia.add("03");listDia.add("04");listDia.add("05");listDia.add("06");listDia.add("07");listDia.add("08");listDia.add("09");
        listDia.add("10");listDia.add("11");listDia.add("12");listDia.add("13");listDia.add("14");listDia.add("15");listDia.add("16");listDia.add("17");listDia.add("18");listDia.add("19");
        listDia.add("20");listDia.add("21");listDia.add("22");listDia.add("23");listDia.add("24");listDia.add("25");listDia.add("26");listDia.add("27");listDia.add("28");listDia.add("29");
        listDia.add("30");
        listDia.add("31");


        ArrayAdapter<String> dataAdapterDia = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listDia);

        dataAdapterDia.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerDia.setAdapter(dataAdapterDia);


        //ArrayList Spinner Mes

        List<String> listMes = new ArrayList<String>();
        listMes.add("Mês");
        listMes.add("Janeiro");listMes.add("Fevereiro");listMes.add("Março");
        listMes.add("Abril");listMes.add("Maio");listMes.add("Junho");
        listMes.add("Julho");listMes.add("Agosto");listMes.add("Setembro");
        listMes.add("Outubro");listMes.add("Novembro");listMes.add("Dezembro");


        ArrayAdapter<String> dataAdapterMes = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listMes);

        dataAdapterMes.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerMes.setAdapter(dataAdapterMes);


        //ArrayList Spinner Ano

        List<String> listAno = new ArrayList<String>();
        listAno.add("Ano");
        listAno.add("2016");
        listAno.add("2017");
        listAno.add("2018");
        listAno.add("2019");
        listAno.add("2020");


        ArrayAdapter<String> dataAdapterAno = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, listAno);

        dataAdapterAno.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinnerAno.setAdapter(dataAdapterAno);
    }

    @Override
    public void onBackPressed() {
        Intent main = new Intent(this, Lista.class);
        startActivity(main);
        this.finish();
    }
}
