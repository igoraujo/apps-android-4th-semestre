package br.com.cotemig.eat.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import br.com.cotemig.eat.R;
import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.ui.fragments.DetailFragment;

/**
 * Created by fourt on 21/05/2018.
 */

public class AdapterDetail extends BaseAdapter {

    Context context;
    List<ModelDateail> list;

    public AdapterDetail(Context context, List<ModelDateail> list) {
        this.list = list;
        this.context = context;
    }

    public AdapterDetail(String detail, DetailFragment detailFragment) {
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
    public View getView(int position, View convertView, ViewGroup parent                                                                                                                                                                                                                                                  ) {


        ModelDateail modelDateail = list.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, null);

        ImageView picture = view.findViewById(R.id.picture);
        TextView name = view.findViewById(R.id.name);
        TextView detail = view.findViewById(R.id.detail);
        TextView latitude = view.findViewById(R.id.latitude);
        TextView longitude = view.findViewById(R.id.longitude);

        Glide.with(picture)
                .load(modelDateail.getPicture())
                .into(picture);

        name.setText(modelDateail.getName());
        detail.setText(modelDateail.getDetail());
        latitude.setText(modelDateail.getLatitude());
        longitude.setText(modelDateail.getLongitude());

        return view;
    }
}
