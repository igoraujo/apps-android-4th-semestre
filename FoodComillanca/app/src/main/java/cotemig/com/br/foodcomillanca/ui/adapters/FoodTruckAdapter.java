package cotemig.com.br.foodcomillanca.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cotemig.com.br.foodcomillanca.R;
import cotemig.com.br.foodcomillanca.model.ModelFoodtruck;

public class FoodTruckAdapter extends BaseAdapter {

    Context context;
    List<ModelFoodtruck> foodtrucks;

    public FoodTruckAdapter(Context context, List<ModelFoodtruck> foodtrucks) {
        this.context = context;
        this.foodtrucks = foodtrucks;
    }

    @Override
    public int getCount() {
        return foodtrucks.size();
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

        ModelFoodtruck foodtruck = foodtrucks.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_food_truck,null);

        ImageView picture = v.findViewById(R.id.picture);
        TextView name = v.findViewById(R.id.name);
        TextView detail = v.findViewById(R.id.detail);
        TextView latitude = v.findViewById(R.id.latitude);
        TextView longitude = v.findViewById(R.id.longitude);

        Glide.with(picture)
                .load(foodtruck.getPicture())
                .into(picture);
        name.setText(foodtruck.getName());
        detail.setText(foodtruck.getDetail());
        latitude.setText(foodtruck.getLatitude());
        longitude.setText(foodtruck.getLongitude());



        return v;
    }
}
