package org.atctech.lowinternettv.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.atctech.lowinternettv.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Latest extends Fragment {


    public Latest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latest, container, false);



        return view;
    }

}
