package com.example.daniel.cancun_night.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniel.cancun_night.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayaFragment extends Fragment {


    public PlayaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playa, container, false);
    }

}
