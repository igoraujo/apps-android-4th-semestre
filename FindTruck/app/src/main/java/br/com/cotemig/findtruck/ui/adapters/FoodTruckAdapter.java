package br.com.cotemig.findtruck.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cotemig.findtruck.R;
import br.com.cotemig.findtruck.model.ModelFoodTruck;

/**
 * Created by dirceu on 04/06/2018.
 */

public class FoodTruckAdapter extends BaseAdapter {

    private Context context;
    private List<ModelFoodTruck> listFoodTruck;

    public FoodTruckAdapter(Context context, List<ModelFoodTruck> listFoodTruck) {
        this.context = context;
        this.listFoodTruck = listFoodTruck;
    }

    @Override
    public int getCount() {
        return listFoodTruck.size();
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

        ModelFoodTruck m = listFoodTruck.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_foodtruck, null);

        TextView nome = view.findViewById(R.id.nome);
        nome.setText(m.getName());

        TextView descricao = view.findViewById(R.id.descricao);
        descricao.setText(m.getDetail());

        return view;
    }
}
