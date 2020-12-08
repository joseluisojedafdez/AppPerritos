package com.i4bchile.appperritos.view;

import android.icu.number.LocalizedNumberFormatter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.model.Repository;
import com.i4bchile.appperritos.presenter.IBreedPresenterView;
import com.i4bchile.appperritos.presenter.PicturesPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PicturesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PicturesFragment extends Fragment implements IBreedPresenterView, OnItemLongClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Infolog";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvBreedTitle;
    private PicturesPresenter presenter;
    private PicturesAdapter adapter;
    private RecyclerView recyclerview;

    public PicturesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PicturesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PicturesFragment newInstance(String param1, String param2) {
        PicturesFragment fragment = new PicturesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_pictures, container, false);
        tvBreedTitle=view.findViewById(R.id.textView);
        tvBreedTitle.setText("Picture list for breed: " +mParam2.toUpperCase());
        Log.d(TAG, "onCreate View: llamando al presentador de Pictures");
        adapter=new PicturesAdapter(new ArrayList<>(),this);
        presenter=new PicturesPresenter(this,new Repository(),mParam2);
        recyclerview=view.findViewById(R.id.rv_Pictures);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerview.setAdapter(adapter);

        return view;
    }

    @Override
    public void showBreed(List<String> breeds) {
            adapter.updatePictures(breeds);
    }

    @Override
    public void onLongClick(int position) {
        Log.d(TAG, "onClick: haciendo long click en el elemento de la lista"+adapter.getListOfPictures().get(position));
        Toast.makeText(getContext(),"Adding the picture "+adapter.getListOfPictures().get(position)+" to favorites", Toast.LENGTH_LONG).show();
        presenter.addFavorite(adapter.getListOfPictures().get(position),mParam2);
    }
}