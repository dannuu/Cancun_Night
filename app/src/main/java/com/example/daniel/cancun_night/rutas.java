package com.example.daniel.cancun_night;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import static com.example.daniel.cancun_night.R.id.map;

/**
 * Created by daniel on 15/08/2017.
 */

public class rutas  extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnPolylineClickListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnPolygonClickListener{

    private GoogleMap mMap;
    Button bmapa;
    Button bterreno;
    Button bhibrido;
    Button binterior;

    private Marker mPerth;
    static final LatLng MELBOURNE = new LatLng(21.025966893662414, -86.81762337684631);
    static final LatLng MELBOURNE2 = new LatLng(21.17356724072934, -86.82713985443115);
    static final LatLng CENTRO = new LatLng(21.17356724072934, -86.82713985443115);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rutas);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {
                mMap.clear();
                switch (menuButton.getId()) {

                    case R.id.favorite:
                        showMessage("Zona Hotelero");
                        Marker perth = mMap.addMarker(new MarkerOptions()
                                .position(MELBOURNE)
                                .title("Transportation downtown - Final Station")
                                .snippet("Price: 12.50 MX")
                                .snippet("ROUTES: R1,R23,R26")
                                .draggable(true));
                        Marker perth2 = mMap.addMarker(new MarkerOptions()
                                .position(MELBOURNE2)
                                .title("Transportation downtown - Main Station")
                                .snippet("ROUTES: R1,R23,R26")
                                .draggable(true));



                        Polyline polyline1 = mMap.addPolyline(new PolylineOptions()
                                .clickable(true)
                                .add(
                                        //Coordenadas de punta nizuk - centro ciudad de cancun
                                        new LatLng(21.025966893662414, -86.81762337684631), new LatLng(21.025345994126262, -86.81434571743011), new LatLng(21.028961195435038, -86.81179225444794), new LatLng(21.03379801737015, -86.8058431148529),new LatLng(21.037022478101164, -86.79921269416809),
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
                                        new LatLng(21.058870866501536, -86.78155839443207),
                                        new LatLng(21.060574946077892, -86.77999158213424),
                                        new LatLng(21.06314003969187, -86.77919188145097),
                                        new LatLng(21.068976914378908, -86.78059735897477), new LatLng(21.071990374046962, -86.77943864468034),
                                        new LatLng(21.086806495976273, -86.77350559817569),
                                        new LatLng(21.106669794552325, -86.76370936474996),
                                        new LatLng(21.109332179528447, -86.76306563458638),
                                        new LatLng(21.112635071954397, -86.76122027478414),
                                        new LatLng(21.11801963474307, -86.75729352078633),
                                        new LatLng(21.123504076444018, -86.75510483823018),
                                        new LatLng(21.129516717190782, -86.75036108179484),
                                        new LatLng(21.134640476045803, -86.74589788599405),
                                        new LatLng(21.138122929790914, -86.75018942041788),
                                        new LatLng(21.135721246309814, -86.7526785103837),
                                        new LatLng(21.134672490896413, -86.75540524760436),
                                        new LatLng(21.135753260888787, -86.76424580786261),
                                        new LatLng(21.14375871969702, -86.77742081985343),
                                        new LatLng(21.143698680062663, -86.78207713470329),
                                        new LatLng(21.14263798123864, -86.78619700775016),
                                        new LatLng(21.14483942319072, -86.79012376174796),
                                       new LatLng(21.154013080082002, -86.79885542602278),
                                        new LatLng(21.158855837284122, -86.80400526733138),
                                        new LatLng(21.155974215811085, -86.82164347381331),
                                        new LatLng(21.157166892930103, -86.82515555934515),
                                        new LatLng(21.171094098735608, -86.82627135829534),
                                        new LatLng(21.17356724072934, -86.82713985443115)



                                ));
                        //pocision por coordenadas y zoom de la ciudad de cancun
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(21.093469265616505, -86.79302215576172), 12));


                        break;

                    case R.id.search:

                        showMessage("Downtown - City");
                        Marker CENTRICO = mMap.addMarker(new MarkerOptions()
                                .position(CENTRO)
                                .title("Transportation downtown - Main Station")
                                .snippet("ROUTES: R1,R23,R26")
                                .draggable(true));


                        showMessage("Zona Hotelero");
                        Polyline polyline2 = mMap.addPolyline(new PolylineOptions()
                                .clickable(true)
                                .add(
                                        //Coordenadas de punta nizuk - centro ciudad de cancun
                                        new LatLng(21.17356724072934, -86.82713985443115),
                                        new LatLng(21.16230570409359, -86.8256863653005),

                                        new LatLng(21.150068717254744, -86.8247314990549),

                                        new LatLng(21.16230570409359, -86.8256863653005),
                                        new LatLng(21.14975852700719, -86.82184544207303),

                                        new LatLng(21.14906810122063, -86.82195273041316),
                                        new LatLng(21.14749712040876, -86.82340112326074)

                                        ));



                        break;


                    case R.id.alert:
                        showMessage("Alert");
                        break;

                }



            }
        }

        );

        circleMenu.setStateUpdateListener(new CircleMenu.OnStateUpdateListener() {
            @Override
            public void onMenuExpanded() {
                Log.d("CircleMenuStatus", "Expanded");
            }

            @Override
            public void onMenuCollapsed() {
                Log.d("CircleMenuStatus", "Collapsed");
            }
        });
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
        mMap.clear();

    }

   /* @Override
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
*/
    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }


    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
