package br.com.cotemig.igor.questao4.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cotemig.igor.questao4.R;
import br.com.cotemig.igor.questao4.models.ModelProva;

/**
 * Created by 71600388 on 16/04/2018.
 */

public class AdapterProva extends BaseAdapter {

    private List<ModelProva> list;
    private Context context;

    public AdapterProva(List<ModelProva> list, Context context){
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

        ModelProva prova = list.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_prova, null);

        ImageView foto = view.findViewById(R.id.foto);
        Glide.with(context).load(prova.getFoto()).into(foto);

        TextView nome = view.findViewById(R.id.nome);
        nome.setText(prova.getNome());

        return view;

    }
}
