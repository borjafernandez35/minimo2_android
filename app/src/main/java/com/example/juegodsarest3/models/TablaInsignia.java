package com.example.juegodsarest3.models;

public class TablaInsignia {
    int id;
    String correo;

    String nombreinsignia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreinsignia() {
        return nombreinsignia;
    }

    public void setNombreinsignia(String nombreinsignia) {
        this.nombreinsignia = nombreinsignia;
    }

    public TablaInsignia(int id, String correo, String nombreinsignia) {
        this.id = id;
        this.correo = correo;
        this.nombreinsignia = nombreinsignia;
    }
}
