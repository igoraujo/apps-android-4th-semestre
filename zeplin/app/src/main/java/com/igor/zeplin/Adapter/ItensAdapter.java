package com.igor.zeplin.Adapter;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.igor.zeplin.R;

import java.util.List;

public class ItensAdapter extends BaseAdapter {

    Context context;
    List<String> descriptions;
    List<String> prices;
    List<Button> buttonRate;

    public ItensAdapter(Context context, List<String> descriptions) {
        this.context = context;
        this.descriptions = descriptions;
        this.prices = prices;
        this.buttonRate = buttonRate;

    }

    @Override
    public int getCount() {
        return descriptions.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        String description = descriptions.get(position);
        String price = prices.get(position);

        //Obtem o objeto inflater responsavel por inflar o layout xml
        LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // inflando xml criado para cada item
        View view = inflater.inflate(R.layout.item_02, null);

        TextView desc = view.findViewById(R.id.description);
        TextView pri = view.findViewById(R.id.price);
        Button bt = view.findViewById(R.id.buttonRate);

        desc.setText(description);
        pri.setText(price);
        bt.setText((CharSequence) bt);

        return view;

    }

}
