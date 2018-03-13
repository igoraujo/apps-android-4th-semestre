package com.igor.listviewclick.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.igor.listviewclick.R;

import java.util.List;

/**
 * Created by 71600388 on 12/03/2018.
 */

public class CidadeAdapter  extends BaseAdapter{

    Context context;
    List<String> cidades;

    public CidadeAdapter(Context context, List<String> cidades) {
        this.context = context;
        this.cidades = cidades;
    }

    @Override
    public int getCount() {
        return cidades.size();
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
        String cidade = cidades.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_estado, null);

        TextView nome = view.findViewById(R.id.nome);

        nome.setText(cidade);

        return view;
    }
}
