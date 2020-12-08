package com.i4bchile.appperritos.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.i4bchile.appperritos.data.RetrofitClient;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.PicturesPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class Repository {


    private BreedPresenter breedPresenter;
    private PicturesPresenter picturesPresenter;
    private static final String TAG = "InfoLog";
    private List<String> breedsPicture=new ArrayList<>();
    private FirebaseFirestore dbFavorites= FirebaseFirestore.getInstance();

    public void setPicturesPresenter(PicturesPresenter picturesPresenter) {
        this.picturesPresenter = picturesPresenter;
    }



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
                Log.d(TAG, "onResponse: Enviando lista al presentador"+breeds.toString().toUpperCase());
                breedPresenter.showBreed(breeds);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de Conexión"+t.toString());



            }
        });
    }

    public void loadBreedPictures(String pBreed){
        RetrofitClient.getRetrofitInstance().getBreedDetail(pBreed).enqueue(new Callback<BreedImage>(){
            @Override
            public void onResponse(Call<BreedImage> call, Response<BreedImage> response) {
                Log.d(TAG, "onResponse: Lista imagenes "+pBreed.toUpperCase());
                Log.d(TAG, "onResponse: Lista de fotos: "+response.body().getMessage().toString());
                breedsPicture.addAll(response.body().getMessage());
                Log.d(TAG, "onResponse: Enviando lista imágenes al presentador"+pBreed.toUpperCase());
                picturesPresenter.showBreed(breedsPicture);
            }

            @Override
            public void onFailure(Call<BreedImage> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de conexión. Error:  "+ t);

            }
        });
    }

    public void loadNewFavorite(String pPicture, String pBreed){

        Map<String,Object> favorite=new HashMap<>();
        favorite.put("breed",pBreed);
        favorite.put("urlPicture",pPicture);
        favorite.put("timeStamp",new Date().toString() );

        dbFavorites.collection("favorites")
                .add(favorite)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

}
