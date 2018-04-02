package com.example.hiago.exercicio3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hiago.exercicio3.R;
import com.example.hiago.exercicio3.to.Estado;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by hiago on 20/06/2017.
 */
public class AdapterEstado extends BaseAdapter {

    private List<Estado> list;
    private Context context;

    public AdapterEstado(List<Estado> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Estado e = list.get(position);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_list, null);
        TextView txtEstado = (TextView)v.findViewById(R.id.txtEstado);
        txtEstado.setText(e.getDescricao());
        return v;

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
