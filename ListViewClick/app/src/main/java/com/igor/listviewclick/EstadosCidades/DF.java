package com.igor.listviewclick.EstadosCidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 18/03/2018.
 */

public class DF {

    List<String> cidades = new ArrayList<>();

    public DF() {}

    public List<String> getCidades() {

        this.cidades.add("Brasília");
        return cidades;
    }
}