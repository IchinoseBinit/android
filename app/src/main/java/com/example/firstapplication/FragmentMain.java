package com.example.firstapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMain extends Fragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedBundle) {
        View view = layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
        return view;
    }
}
