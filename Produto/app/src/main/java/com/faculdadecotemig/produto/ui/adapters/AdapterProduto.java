package com.faculdadecotemig.produto.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.faculdadecotemig.produto.R;
import com.faculdadecotemig.produto.models.ModelProduto;

import java.util.List;

/**
 * Created by 71600388 on 13/04/2018.
 */

public class AdapterProduto extends BaseAdapter {

    private List<ModelProduto> list;
    private Context context;

    public AdapterProduto(List<ModelProduto> list, Context context) {
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

        ModelProduto post = list.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.produto, null);

        ImageView imagem = view.findViewById(R.id.imagem);
        Glide.with(context).load(post.getImagem()).into(imagem);

        TextView valor = view.findViewById(R.id.valor);
        valor.setText(post.getValor());

        TextView nome = view.findViewById(R.id.nome);
        nome.setText(post.getNome());

        return view;


    }
}
