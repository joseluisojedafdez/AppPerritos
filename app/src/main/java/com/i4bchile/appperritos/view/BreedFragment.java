package com.i4bchile.appperritos.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.IBreedPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreedFragment extends Fragment implements IBreedPresenter {

    BreedPresenter presenter=new BreedPresenter();
    BreedAdapter adapter=new BreedAdapter();

    public BreedFragment() {
        // Required empty public constructor
    }

    public static BreedFragment newInstance() {
        BreedFragment fragment = new BreedFragment();
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

    @Override
    public void showBreed() {

    }
}