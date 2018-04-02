package br.com.cotemig.hiagoexercicio2.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.cotemig.hiagoexercicio2.R;
import br.com.cotemig.hiagoexercicio2.model.Feed;
import br.com.cotemig.hiagoexercicio2.model.User;
/**
 * Created by Hiago on 19/06/2017.
 */
public class AdapterFeed extends BaseAdapter {

    private Context context;
    private List<Feed> list;

    public AdapterFeed(Context context, List<Feed> list) {
        this.context = context;
        this.list = list;
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

        Feed f = list.get(position);

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflate.inflate(R.layout.item_feed, null);

        ImageView image = (ImageView) v.findViewById(R.id.image);

        Picasso.with(context).load(f.getImage()).resize(500, 500)
                .centerCrop()
                .into(image);

        TextView description = (TextView) v.findViewById(R.id.description);
        description.setText(f.getDescription());

        TextView date = (TextView) v.findViewById(R.id.date);
        date.setText(f.getDate());

        TextView likes = (TextView) v.findViewById(R.id.likes);
        likes.setText(f.getLikes().size() + " Curtidas");

        TextView users = (TextView) v.findViewById(R.id.users);
        String us = "";
        for(User u : f.getLikes()){
            us += u.getName() + ", ";
        }
        users.setText(us);
        return v; // tava return null por isso o erro
    }
}
