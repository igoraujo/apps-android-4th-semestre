package br.com.cotemig.instagramfake.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cotemig.instagramfake.R;
import br.com.cotemig.instagramfake.model.ModelPost;
import br.com.cotemig.instagramfake.model.ModelUsuario;

/**
 * Created by 71600388 on 26/03/2018.
 */

public class AdapterFeed extends BaseAdapter {

    private List<ModelPost> lista;
    private Context context;

    public AdapterFeed(List<ModelPost> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
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

        ModelPost post = lista.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_feed, null);

        ImageView imagem = view.findViewById(R.id.imagem);
        Glide.with(context).load(post.getImagem()).into(imagem);

        TextView descricao = view.findViewById(R.id.descricao);
        descricao.setText(post.getDescricao());

        TextView likes = view.findViewById(R.id.likes);
        likes.setText(post.getLikes().size() + " likes");

        TextView data = view.findViewById(R.id.data);
        data.setText(post.getData());

        String us = "";

        for(ModelUsuario u : post.getLikes()){
            us += u.getUsuario() + ", ";
        }

        TextView usuarios = view.findViewById(R.id.usuarios);
        usuarios.setText(us);

        return view;
    }
}
