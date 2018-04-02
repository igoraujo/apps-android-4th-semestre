package br.com.cotemig.hiagoexercicio2.model;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Hiago on 19/06/2017.
 */
public class User {
    @SerializedName("usuario")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
