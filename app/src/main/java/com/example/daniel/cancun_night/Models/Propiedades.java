package com.example.daniel.cancun_night.Models;

/**
 * Created by daniel on 15/07/2017.
 */

public class Propiedades {

    String name;
    String descripcion;
    String img_icon;
    String img_url;
    String img_url_2;
    String img_url_3;
    Double x_coor;
    Double y_coor;

    String page_url;

    int telefono;
    String email;

    public Propiedades() {
    }


    public Propiedades(String name,String descripcion, String img_icon, String img_url,  String img_url_2, String img_url_3,
                       Double x_coor,Double y_coor,String page_url,int telefono,String email ) {

        this.name = name;
        this.descripcion = descripcion;
        this.img_icon = img_icon;

        this.img_url = img_url;
        this.img_url_2 = img_url_2;
        this.img_url_3 = img_url_3;

        this.x_coor = x_coor;
        this.y_coor = y_coor;

        this.page_url = page_url;
        this.telefono=telefono;
        this.email=email;

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


    public String getImg_url() {
        return img_url;
    }
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url_2() {
        return img_url_2;
    }
    public void setImg_url_2(String img_url_2) {
        this.img_url_2 = img_url_2;
    }

    public String getImg_url_3() {
        return img_url_3;
    }
    public void setImg_url_3(String img_url_3) {
        this.img_url_3 = img_url_3;
    }


    public Double getx_coor() {
        return x_coor;
    }
    public Double gety_coor() {
        return y_coor;
    }

    public int get_tel() {
        return telefono;
    }
    public void set_tel(int telefono) {this.telefono = telefono;}

    public String get_web() {return page_url;}
    public void set_web(String page_url) {
        this.page_url = page_url;
    }


    public String get_email() {return email;}
    public void set_email(String email) {
        this.email = email;
    }






}
