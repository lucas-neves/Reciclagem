package com.reciclagem.reciclagem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.Logger;
import com.reciclagem.reciclagem.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        list = (ListView) findViewById(R.id.List);

        List<Produto> produtos = new ArrayList<Produto>(3);
        Produto um = new Produto(1, "Garrafa pet", 5, "http://1.bp.blogspot.com/-Qfd9tdwJ3GI/Ux9ZiWL3P8I/AAAAAAAAAwI/DAgTIgItZKY/s1600/Garrafa+pet-767189.JPG");
        Produto dois = new Produto(2, "Garrafa agua", 3, "https://thumbs.dreamstime.com/b/garrafa-de-%C3%A1gua-vazia-35081089.jpg");
        Produto tres = new Produto(3, "Latinha alumínio", 4, "https://http2.mlstatic.com/lata-latinha-pepsi-cola-antiga-aluminio-vazia-D_NQ_NP_774891-MLB26515383370_122017-F.jpg");
        produtos.add(um);
        produtos.add(dois);
        produtos.add(tres);

        final AdapterProduto adapterProdutos = new AdapterProduto(this, produtos);
        list.setAdapter(adapterProdutos);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long i)
            {
                Intent informations = new Intent(Lista.this, TelaProduto.class);
                informations.putExtra("Produto", adapterProdutos.getItem(position));
                startActivity(informations);
                finish();
            }
        });
    }

}

