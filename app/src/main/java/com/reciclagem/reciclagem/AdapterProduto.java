package com.reciclagem.reciclagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reciclagem.reciclagem.modelo.Produto;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lucasn on 23/09/2016.
 */
public class AdapterProduto extends BaseAdapter {

    private Context context;
    List<Produto> produtos;

    public AdapterProduto(Context context, List<Produto> produtos)
    {
        this.context = context;
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public String[] getItem(int position) {
        String[] produto = new String[3];
        produto[0] = produtos.get(position).getDescricao();
        produto[1] = String.valueOf(produtos.get(position).getValor());
        produto[2] = produtos.get(position).getImage_Path();

        return produto;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item_favoritos, null);

        if(view != null){
            ImageView imgProduto = (ImageView) view.findViewById(R.id.imageView);
            TextView nome = (TextView) view.findViewById(R.id.textViewNome);
            TextView valor = (TextView) view.findViewById(R.id.textViewDescricao);

            Produto produto = produtos.get(position);

            nome.setText(produto.getDescricao());
            valor.setText("R$ "+String.valueOf(produto.getValor()+"0"));

            Picasso.with(context)
                   .load(produto.getImage_Path())
                   .into(imgProduto);
        }
        return view;
    }
}