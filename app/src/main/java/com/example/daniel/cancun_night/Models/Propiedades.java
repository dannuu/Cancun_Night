package com.example.daniel.cancun_night.Models;

/**
 * Created by daniel on 15/07/2017.
 */

public class Propiedades {

    String name;
    String descripcion;
    String idioma;
    String img_icon;
    String correo;
    int telefono;
    String img_url;
    String img_url_2;
    String img_url_3;
    String x_coor;
    String y_coor;


    public Propiedades() {
    }


    public Propiedades(
            String name,String descripcion, String img_icon , String correo,String idioma,int telefono, String img_url,
            String img_url_2, String img_url_3, String x_coor, String y_coor) {

        this.name = name;
        this.descripcion = descripcion;
        this.img_icon = img_icon;
        this.correo= correo;
        this.idioma=idioma;
        this.telefono=telefono;
        this.img_url=img_url;
        this.img_url_2=img_url_2;
        this.img_url_3=img_url_3;
        this.x_coor=x_coor;
        this.y_coor=y_coor;
    }

    public String getName() {return name;}
    public String getDescripcion() {return descripcion;}
    public String getImg_icon() {return img_icon;}

    public String getCorreo() {return correo;}
    public String getIdioma() {return idioma;}
    public int getTelefono() {return telefono;}

    public String getImg_url() {return img_url;}
    public String getImg_url_2() {return img_url_2;}
    public String getImg_url_3() {return img_url_3;}

    public String getX_coor() {return x_coor;}
    public String getY_coor() {return y_coor;}




}
