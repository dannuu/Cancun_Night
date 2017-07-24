package com.example.daniel.cancun_night.Fragment;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.cancun_night.ConexionLocal;
import com.example.daniel.cancun_night.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracionFragment extends Fragment implements View.OnClickListener {

    private SQLiteDatabase db;
    private TextView txtResultado;
    public String IdiomaEspañol = "Español";
    public int  valor = 1;

    public String IdiomaEnglish = "English";
    public int  valor2 = 2;

    public ConfiguracionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_configuracion,
                container, false);

        ConexionLocal usdbh =
                new ConexionLocal(getActivity(), "DBNight", null, 2);
        db = usdbh.getWritableDatabase();

        Button English = (Button) view.findViewById(R.id.BtnEnglish);
        English.setOnClickListener(this);

        Button Spanish = (Button) view.findViewById(R.id.BtnSpanish);
        Spanish.setOnClickListener(this);

        return view;



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnSpanish:
            {
                String sql = "DELETE FROM idiomas ";
                db.execSQL(sql);


                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("codigo", valor);
                nuevoRegistro.put("nombre", IdiomaEspañol);
                db.insert("idiomas", null, nuevoRegistro);

                Toast.makeText(getActivity(),""+nuevoRegistro, Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.BtnEnglish:
            {
                String sql2 = "DELETE FROM idiomas ";
                db.execSQL(sql2);


                ContentValues nuevoRegistro2 = new ContentValues();
                nuevoRegistro2.put("codigo", valor2);
                nuevoRegistro2.put("nombre", IdiomaEnglish);
                db.insert("idiomas", null, nuevoRegistro2);

                Toast.makeText(getActivity(),""+nuevoRegistro2, Toast.LENGTH_SHORT).show();
                break;
            }


        }
    }



}
