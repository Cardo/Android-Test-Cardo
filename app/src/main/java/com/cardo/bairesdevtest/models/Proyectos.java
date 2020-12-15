package com.cardo.bairesdevtest.models;

// Clase con subconjunto de fields del REST API de GitHub para uso de RetroFit
public class Proyectos {
    private int id;
    private String full_name;
    private String html_url;

    public int getId() {
        return id;
    }
    public String getNombre() {
        return full_name;
    }
    public String getDireccion() {
        return html_url;
    }
}
