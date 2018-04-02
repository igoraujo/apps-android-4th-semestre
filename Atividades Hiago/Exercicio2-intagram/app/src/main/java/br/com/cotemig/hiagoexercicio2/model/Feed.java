package br.com.cotemig.hiagoexercicio2.model;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Created by Hiago on 19/06/2017.
 */
public class Feed {
    @SerializedName("descricao")
    private String description;
    @SerializedName("data")
    private String date;
    @SerializedName("imagem")
    private String image;
    private List<User> likes;
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
    public List<User> getLikes() {
        return likes;
    }
    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
}
