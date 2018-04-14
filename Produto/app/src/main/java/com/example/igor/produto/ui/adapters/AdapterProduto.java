package com.example.igor.produto.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;
import com.example.igor.produto.R;
import com.example.igor.produto.models.ModelProduto;

/**
 * Created by Igor on 14/04/2018.
 */

public class AdapterProduto extends BaseAdapter {

    private List<ModelProduto> list;
    private Context context;

    public AdapterProduto(List<ModelProduto> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModelProduto produto = list.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_produto, null);

        ImageView imagem = view.findViewById(R.id.imagem);
        Glide.with(context).load(produto.getImagem()).into(imagem);

        TextView valor = view.findViewById(R.id.valor);
        valor.setText(produto.getValor());

        TextView nome = view.findViewById(R.id.nome);
        nome.setText(produto.getNome());

        return view;

    }
}
