package com.igor.instafake.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 71600388 on 02/04/2018.
 */

public class ModelFeed {
    @SerializedName("descricao")
    private String description;
    @SerializedName("data")
    private String date;
    @SerializedName("imagem")
    private String image;
    private List<ModelUser> likes;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<ModelUser> getLikes() {
        return likes;
    }
    public void setLikes(List<ModelUser> likes) {
        this.likes = likes;
    }
}
