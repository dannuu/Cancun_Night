package com.example.daniel.cancun_night;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.name;
import static com.example.daniel.cancun_night.R.id.descripcion;

public class VerDetalleActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


        private FirebaseAuth firebaseAuth;
        private FirebaseAuth.AuthStateListener firebaseAuthListener;
        private GoogleApiClient googleApiClient;
        private FirebaseDatabase database;
        private String UID_user;

        TextView nombreProducto, precioProducto, descProducto;
        ImageView imgProducto;
        Button add_to_cart;
        private String[] arrayURL;

    String  name,img,img_1,img_2,img_3,imgnew, descripcion;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


       /* carouselView = (CarouselView) findViewById(R.id.carouselView);
        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        carouselLabel = (TextView) findViewById(R.id.carouselLabel);
        customCarouselLabel = (TextView) findViewById(R.id.customCarouselLabel);


        carouselView.setPageCount(sampleImages.length);

        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setSlideInterval(4000);

        carouselView.setImageListener(imageListener);
        customCarouselView.setViewListener(viewListener);
*/

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //Firebase
        //database = FirebaseDatabase.getInstance();

        //Firebase auth

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    setUserData(user);
                } else {
                    goLogInScreen();
                }
            }
        };

        nombreProducto = (TextView) findViewById(R.id.TitleName);
        imgProducto = (ImageView) findViewById(R.id.img);
        descProducto = (TextView) findViewById(R.id.descripcion);


            Bundle extras = getIntent().getExtras();
            img = extras.getString("img");


            //  Toast.makeText(getApplicationContext(), getUrlFirebase().length, Toast.LENGTH_SHORT).show();

            name = extras.getString("name");
            descripcion = extras.getString("descripcion");

            Glide.with(this).load(img).into(imgProducto);
            nombreProducto.setText(name);
            descProducto.setText(descripcion);


    }


    private void setUserData(FirebaseUser user) {

        UID_user = user.getUid();
        //descProducto.setText(UID_user);

    }


    private void goLogInScreen() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener != null){

            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }










}

