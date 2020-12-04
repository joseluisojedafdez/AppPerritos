package com.i4bchile.appperritos.data;

import com.i4bchile.appperritos.model.BreedList;
import com.i4bchile.appperritos.model.Favorites;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDogs {

    @GET("breeds/list")
    Call<BreedList> getAllBreeds();
    @GET("breed/{breed}/images/")
    Call <Favorites> getBreedDetail(@Path("breed") String breed);
}
