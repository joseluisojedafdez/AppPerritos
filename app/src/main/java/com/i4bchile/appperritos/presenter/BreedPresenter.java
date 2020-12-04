package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.data.RetrofitClient;
import com.i4bchile.appperritos.model.Breed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedPresenter {

IBreedPresenter viewBreed;

    private static final String TAG = "BreedListPresenter";

public void lodadBreedList(){
    RetrofitClient.getRetrofitInstance().getAllBreeds().enqueue(new Callback<Breed>() {
        @Override
        public void onResponse(Call<Breed> call, Response<Breed> response) {
            Log.d(TAG, "onResponse: Lista razas: "+response.body().getMessage().keySet().toString());
        }

        @Override
        public void onFailure(Call<Breed> call, Throwable t) {
            Log.d(TAG, "onFailure: Fallo de Conexión"+t.toString());

        }
    });
}

}
