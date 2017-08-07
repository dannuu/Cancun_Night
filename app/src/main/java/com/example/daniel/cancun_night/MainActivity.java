package com.example.daniel.cancun_night;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.daniel.cancun_night.Fragment.ConfiguracionFragment;
import com.example.daniel.cancun_night.Fragment.PlayaFragment;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    /**
     * Instancia del drawer
     */

    /**
     * Titulo inicial del drawer
     */
    private String drawerTitle;
    private DrawerLayout drawerLayout;
    Button playButton,playButton2;

    private GoogleApiClient googleApiClient;

    private FirebaseAuth firebaseAuth;
    private  FirebaseAuth.AuthStateListener firebaseAuthListener;
    //Variables idiomas BD local
    public String cod,nom;

    private TextView userName, emailUser, idiomaUser, txt1,txt2;
    private ImageView imgUser;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConexionLocal usdbh =
                new ConexionLocal(this, "DBNight", null, 2);
        db = usdbh.getWritableDatabase();


        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.home_item);
        if (savedInstanceState == null) {
            selectItem(drawerTitle);
        }



        userName = (TextView)navigationView.getHeaderView(0).findViewById(R.id.username);
        emailUser = (TextView)navigationView.getHeaderView(0).findViewById(R.id.email);
        //  idiomaUser = (TextView)navigationView.getHeaderView(0).findViewById(R.id.textViewIdioma);
        imgUser = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.circle_image);





        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                //Si el usuario esta
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    setUserData(user);
                }
                else{
                    goLogInScreen();
                }
            }
        };

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }



    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        //Pequeño bug hace que los botones y textos de inicio o home existan en todos las categorias con este codigo los escodemos

                        int id = menuItem.getItemId();
                        boolean fragmentTansaction = false;
                        Fragment fragment = null;

                        //Entra a la funcion de las opciones de las categorias entrando a un fragment con su respectivo xml
                        switch (id) {


                            case R.id.nav_playa: {
                                fragment = new PlayaFragment();
                                fragmentTansaction = true;
                                break;
                            }


                            case R.id.nav_restaurante: {

                                fragment = new ConfiguracionFragment();
                                fragmentTansaction = true;
                                break;
                            }


                        }
                        if (fragmentTansaction) {

                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.main_content, fragment)
                                    .commit();
                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;

                    }
                }
        );
    }


    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(String title) {
        // Enviar título como arguemento del fragmento



     // Setear título actual

    }

    public String getIdioma(){
        Cursor c = db.rawQuery("SELECT codigo, nombre FROM idiomas", null);

        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                cod = c.getString(0);
                nom = c.getString(1);

            } while(c.moveToNext());
        }

        return nom;
    }

    private void setUserData(FirebaseUser user) {
        userName.setText(user.getDisplayName());
        emailUser.setText(user.getEmail());
        //idTextView.setText(user.getUid());
        Glide.with(this).load(user.getPhotoUrl()).into(imgUser);
        //Glide sirve para traer la foto desde internet
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    // Pasar de una actividad a otra
    private void goLogInScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // Funcion para cerrar sesion y te redigire al formulario de registro
    public void logOut(){

        firebaseAuth.signOut();

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    goLogInScreen();
                } else {
                    Toast.makeText(getApplicationContext(), "Error al cerrar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null){

            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }


}



