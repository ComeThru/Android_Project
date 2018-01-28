package com.example.danielmorales.comethru;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hello57748 on 1/28/18.
 */

public class first_fragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return myView;
    }
}
