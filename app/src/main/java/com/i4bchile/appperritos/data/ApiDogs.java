package com.i4bchile.appperritos.data;

import com.i4bchile.appperritos.model.Breed;
import com.i4bchile.appperritos.model.BreedImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDogs {

    @GET("breeds/list/all/")
    Call<Breed> getAllBreeds();
    @GET("breed/{breed}/images/")
    Call <BreedImage> getBreedDetail(@Path("breed") String breed);
}
