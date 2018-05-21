package br.com.cotemig.eat.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.cotemig.eat.models.ModelDateail;
import br.com.cotemig.eat.ui.fragments.DetailFragment;

/**
 * Created by fourt on 21/05/2018.
 */

public class AdapterDetail extends BaseAdapter {

    private List<ModelDateail> list;
    private Context context;

    public AdapterDetail(List<ModelDateail> list, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
