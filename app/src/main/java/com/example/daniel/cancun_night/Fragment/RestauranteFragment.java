package com.example.daniel.cancun_night.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.daniel.cancun_night.Adapter.Adapter;
import com.example.daniel.cancun_night.MainActivity;
import com.example.daniel.cancun_night.Models.Propiedades;
import com.example.daniel.cancun_night.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment implements SearchView.OnQueryTextListener {

    RecyclerView rv;

    List<Propiedades> propiedades;
    private ProgressBar progressBar;
    Adapter adapter;




    private FirebaseDatabase database;

    public RestauranteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_propiedades, container, false);

        MainActivity activity = (MainActivity) getActivity(); //Agarramos de la actividad menu principal el valor del string
        String recibeDato = activity.getIdioma(); // La guardamos en un resultado " recibe dato" para poder comparar el idioma

       rv = (RecyclerView) v.findViewById(R.id.recyclerPropiedades);



        //buscamos el id del recyclerview
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        propiedades = new ArrayList<>();

        adapter = new Adapter(propiedades);

        rv.setAdapter(adapter);


        database = FirebaseDatabase.getInstance();
        // progressBar.setVisibility(View.VISIBLE);
        // progressBar.setVisibility(View.GONE);

    Toast.makeText(getActivity(),""+recibeDato, Toast.LENGTH_SHORT).show();
    DatabaseReference tiendaref = database.getReference("Categoria");
    tiendaref.child("Restaurantes").orderByChild("idioma").equalTo(recibeDato).addValueEventListener(new ValueEventListener() {

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            propiedades.removeAll(propiedades);

            for (DataSnapshot snapshot :
                    dataSnapshot.getChildren()) {

                Propiedades propiedades = snapshot.getValue(Propiedades.class);
                RestauranteFragment.this.propiedades.add(propiedades);
            }
            adapter.notifyDataSetChanged();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    return v;
}
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");
        //MenuItem searchItem = menu.findItem(R.id.action_search);

        super.onCreateOptionsMenu(menu, inflater);


    }





    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();

        List<Propiedades> newList = new ArrayList<>();
        for(Propiedades propiedades : this.propiedades){

            String name = propiedades.getName().toLowerCase();
            if(name.contains(newText)){
                newList.add(propiedades);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
