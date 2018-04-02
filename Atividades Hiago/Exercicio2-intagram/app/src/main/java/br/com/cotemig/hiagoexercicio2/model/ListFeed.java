package br.com.cotemig.hiagoexercicio2.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hiago on 19/06/2017.
 */

public class ListFeed {

    @SerializedName("lista")

    private List<Feed> list;

    public List<Feed> getList() {
        return list;
    }

    public void setList(List<Feed> list) {
        this.list = list;
    }
}
