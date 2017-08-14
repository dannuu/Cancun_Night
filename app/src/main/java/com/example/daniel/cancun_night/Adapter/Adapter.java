package com.example.daniel.cancun_night.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daniel.cancun_night.Models.Propiedades;
import com.example.daniel.cancun_night.R;
import com.example.daniel.cancun_night.VerDetalleActivity;

import java.util.ArrayList;
import java.util.List;

import  static  android.media.CamcorderProfile.get;

/**
 * Created by daniel on 21/06/2017.
 */

public class Adapter  extends RecyclerView.Adapter<Adapter.ProductosviewHolder> {


    List<Propiedades> propiedades;
    Context context;

    public Adapter(List<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    @Override
    public ProductosviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        ProductosviewHolder holder = new ProductosviewHolder(v);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductosviewHolder holder, int position) {

        final Propiedades variable =  propiedades.get(position);

       Glide.with(context).load(variable.getImg_icon()).into(holder.imgProducto);
        holder.txtNombre.setText(variable.getName());
      holder.txtDescripcion.setText(variable.getDescripcion());
        final int indice = position;


       holder.BtnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(context, VerDetalleActivity.class  );
                intent.putExtra("img",   variable.getImg_icon());
                intent.putExtra("name", variable.getName());
                intent.putExtra("descripcion", variable.getDescripcion());

                intent.putExtra("img_1",   variable.getImg_url());
                intent.putExtra("img_2",   variable.getImg_url_2());
                intent.putExtra("img_3",   variable.getImg_url_3());

                intent.putExtra("x_coor",   variable.getx_coor());
                intent.putExtra("y_coor",   variable.gety_coor());

                intent.putExtra("web",   variable.get_web());
                intent.putExtra("telefono",   variable.get_tel());

                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return propiedades.size();
    }

    public static class ProductosviewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre, txtDescripcion ;
        ImageView imgProducto;
        Button BtnDetalles;

        public ProductosviewHolder(View itemView) {
            super(itemView);

            imgProducto = (ImageView) itemView.findViewById(R.id.foto);
            txtNombre = (TextView) itemView.findViewById(R.id.nombre);
           txtDescripcion = (TextView) itemView.findViewById(R.id.descripcion);


           BtnDetalles = (Button) itemView.findViewById(R.id.buttonSeeProduct);

        }
    }

    public void setFilter(List<Propiedades> newList){
        propiedades =  new ArrayList<>();
        propiedades.addAll(newList);
        notifyDataSetChanged();
    }


}


