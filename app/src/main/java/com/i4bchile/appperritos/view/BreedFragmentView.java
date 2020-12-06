package com.i4bchile.appperritos.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.IBreedPresenterView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedFragmentView extends Fragment{

    //BreedPresenter presenter=new BreedPresenter();
    //BreedAdapter adapter=new BreedAdapter();

    public BreedFragmentView() {
        // Required empty public constructor
    }

    public static BreedFragmentView newInstance() {
        BreedFragmentView fragment = new BreedFragmentView();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
;
        return inflater.inflate(R.layout.fragment_breed, container, false);
    }




}