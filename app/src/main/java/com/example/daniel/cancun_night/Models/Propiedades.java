package com.example.daniel.cancun_night.Models;

/**
 * Created by daniel on 15/07/2017.
 */

public class Propiedades {

    String name;
    String descripcion;
    String img_icon;

    public Propiedades() {
    }


    public Propiedades(String name,String descripcion, String img_icon ) {

        this.name = name;
        this.descripcion = descripcion;
        this.img_icon = img_icon;

    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }


    public String getImg_icon() {return img_icon;}
    public void setImg_icon(String img_icon) {
        this.img_icon = img_icon;
    }


    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }





}
