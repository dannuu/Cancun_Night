package com.example.daniel.cancun_night;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static com.example.daniel.cancun_night.R.id.map;

/**
 * Created by daniel on 15/08/2017.
 */
/*
public class rutas  extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnPolygonClickListener,
        View.OnClickListener {

    private GoogleMap mMap;
    Button bmapa;
    Button bterreno;
    Button bhibrido;
    Button binterior;

    private Marker mPerth;
    static final LatLng MELBOURNE = new LatLng(21.025966893662414, -86.81762337684631);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rutas);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    @Override
    public void onPolygonClick(Polygon polygon) {

    }

    @Override
    public void onPolylineClick(Polyline polyline) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Marker perth = mMap.addMarker(new MarkerOptions()
                .position(MELBOURNE)
                .title("Transportation downtown - Final Station")
                .snippet("Price: 12.50 MX")
                .snippet("ROUTES: R1,R23,R26")
                .draggable(true));






    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bmapa:
                Polyline polyline1 = mMap.addPolyline(new PolylineOptions()
                        .clickable(true)
                        .add(
                                //Coordenadas de punta nizuk - centro ciudad de cancun
                                new LatLng(21.025966893662414, -86.81762337684631),
                                new LatLng(21.025345994126262, -86.81434571743011),
                                new LatLng(21.028961195435038, -86.81179225444794),
                                new LatLng(21.03379801737015, -86.8058431148529),
                                new LatLng(21.037022478101164, -86.79921269416809),
                                new LatLng(21.037222752863254, -86.7931616306305),
                                new LatLng(21.03385810112742, -86.7872017621994),
                                new LatLng(21.03421860316221, -86.78602159023285),
                                new LatLng(21.034999687911917, -86.78552806377411),
                                new LatLng(21.03762330157969, -86.7851847410202),
                                new LatLng(21.04076757159148, -86.78296387195587),
                                new LatLng(21.04076757159148, -86.78296387195587),
                                new LatLng(21.042605036236143, -86.78290754556656),
                                new LatLng(21.047376330383482, -86.78321063518524),
                                new LatLng(21.050870843369054, -86.78294241428375),
                                new LatLng(21.05551671641239, -86.78253471851349),
                                new LatLng(21.058870866501536, -86.78155839443207)

                        ));
                //pocision por coordenadas y zoom de la ciudad de cancun
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.093469265616505, -86.79302215576172), 12));
                break;
            case R.id.bhibrido:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.bterreno:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.binterior:
                // Algunos edificios tienen mapa de interior. Hay que ponerse sobre ellos y directamente veremos las plantas
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(-33.86997, 151.2089), 18));

                break;
            default:
                break;


        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}



     /*   @Override
        public void onMapReady (GoogleMap googleMap){


        mMap = googleMap;
        Marker perth = mMap.addMarker(new MarkerOptions()
                .position(MELBOURNE)
                .title("Transportation downtown - Final Station")
                .snippet("Price: 12.50 MX")
                .snippet("ROUTES: R1,R23,R26")
                .draggable(true));

        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        //Coordenadas de punta nizuk - centro ciudad de cancun
                        new LatLng(21.025966893662414, -86.81762337684631),
                        new LatLng(21.025345994126262, -86.81434571743011),
                        new LatLng(21.028961195435038, -86.81179225444794),
                        new LatLng(21.03379801737015, -86.8058431148529),
                        new LatLng(21.037022478101164, -86.79921269416809),
                        new LatLng(21.037222752863254, -86.7931616306305),
                        new LatLng(21.03385810112742, -86.7872017621994),
                        new LatLng(21.03421860316221, -86.78602159023285),
                        new LatLng(21.034999687911917, -86.78552806377411),
                        new LatLng(21.03762330157969, -86.7851847410202),
                        new LatLng(21.04076757159148, -86.78296387195587),
                        new LatLng(21.04076757159148, -86.78296387195587),
                        new LatLng(21.042605036236143, -86.78290754556656),
                        new LatLng(21.047376330383482, -86.78321063518524),
                        new LatLng(21.050870843369054, -86.78294241428375),
                        new LatLng(21.05551671641239, -86.78253471851349),
                        new LatLng(21.058870866501536, -86.78155839443207)

                ));
        //pocision por coordenadas y zoom de la ciudad de cancun
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.093469265616505, -86.79302215576172), 12));

    }

*/