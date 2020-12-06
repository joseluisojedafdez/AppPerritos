package com.i4bchile.appperritos.model;

import android.util.Log;

import com.i4bchile.appperritos.data.RetrofitClient;
import com.i4bchile.appperritos.presenter.BreedPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {


    private BreedPresenter breedPresenter;

    private static final String TAG = "InfoLog";

    public void setBreedPresenter(BreedPresenter breedPresenter) {
        this.breedPresenter = breedPresenter;
    }


    public void lodadBreedList(){
        RetrofitClient.getRetrofitInstance().getAllBreeds().enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                Log.d(TAG, "onResponse: Lista razas: "+response.body().getMessage().keySet().toString());
                List<String> breeds=new ArrayList<String>();
                breeds.addAll(response.body().getMessage().keySet());
                Log.d(TAG, "onResponse: Enviando lista al presentador"+breeds.toString());
                breedPresenter.showBreed(breeds);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de Conexión"+t.toString());

            }
        });
    }
}
