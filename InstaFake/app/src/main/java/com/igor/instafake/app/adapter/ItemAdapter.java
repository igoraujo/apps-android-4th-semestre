package com.igor.instafake.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.igor.instafake.R;

import java.util.List;

/**
 * Created by 71600388 on 26/03/2018.
 */

public class ItemAdapter extends BaseAdapter {

   private Context context;
   private List<String> itens;

    public ItemAdapter(Context context, List<String> itens) {
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
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

        String item = itens.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // inflando xml criado para cada item
        View v = inflater.inflate(R.layout.item, null);

        TextView nome = v.findViewById(R.id.nome);

        nome.setText(item);

        return null;
    }
}
