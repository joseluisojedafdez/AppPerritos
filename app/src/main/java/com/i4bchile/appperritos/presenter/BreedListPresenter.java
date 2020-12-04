package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.data.RetrofitClient;
import com.i4bchile.appperritos.model.BreedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedListPresenter {

IBreedListPresenter viewBreedList;

    private static final String TAG = "BreedListPresenter";

public void lodadBreedList(){
    RetrofitClient.getRetrofitInstance().getAllBreeds().enqueue(new Callback<BreedList>() {
        @Override
        public void onResponse(Call<BreedList> call, Response<BreedList> response) {
            Log.d(TAG, "onResponse: Lista razas: "+response.body());
        }

        @Override
        public void onFailure(Call<BreedList> call, Throwable t) {
            Log.d(TAG, "onFailure: Fallo de Conexión"+t.toString());

        }
    });
}

}
