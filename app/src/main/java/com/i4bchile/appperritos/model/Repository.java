package com.i4bchile.appperritos.model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.i4bchile.appperritos.data.RetrofitClient;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.FavoritesPresenter;
import com.i4bchile.appperritos.presenter.PicturesPresenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {


    private static final String TAG = "InfoLog";
    private BreedPresenter breedPresenter;
    private PicturesPresenter picturesPresenter;
    private FavoritesPresenter favoritesPresenter;
    private List<String> breedsPicture = new ArrayList<>();
    private FirebaseFirestore dbFavorites = FirebaseFirestore.getInstance();
    private final Set<Favorites> favoritesListToFilter=new HashSet<>();

    public void setFavoritesPresenter(FavoritesPresenter favoritesPresenter) {
        this.favoritesPresenter = favoritesPresenter;
    }

    public void setPicturesPresenter(PicturesPresenter picturesPresenter) {
        this.picturesPresenter = picturesPresenter;
    }


    public void setBreedPresenter(BreedPresenter breedPresenter) {
        this.breedPresenter = breedPresenter;
    }


    public void lodadBreedList() {
        RetrofitClient.getRetrofitInstance().getAllBreeds().enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                Log.d(TAG, "onResponse: Lista razas: " + response.body().getMessage().keySet().toString());
                List<String> breeds = new ArrayList<String>();
                breeds.addAll(response.body().getMessage().keySet());
                Log.d(TAG, "onResponse: Enviando lista al presentador" + breeds.toString().toUpperCase());
                breedPresenter.showBreed(breeds);

            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de Conexión" + t.toString());


            }
        });
    }

    public void loadBreedPictures(String pBreed) {
        RetrofitClient.getRetrofitInstance().getBreedDetail(pBreed).enqueue(new Callback<BreedImage>() {
            @Override
            public void onResponse(Call<BreedImage> call, Response<BreedImage> response) {
                Log.d(TAG, "onResponse: Lista imagenes " + pBreed.toUpperCase());
                Log.d(TAG, "onResponse: Lista de fotos: " + response.body().getMessage().toString());
                breedsPicture.addAll(response.body().getMessage());
                Log.d(TAG, "onResponse: Enviando lista imágenes al presentador" + pBreed.toUpperCase());
                picturesPresenter.showBreed(breedsPicture);
            }

            @Override
            public void onFailure(Call<BreedImage> call, Throwable t) {
                Log.d(TAG, "onFailure: Fallo de conexión. Error:  " + t);

            }
        });
    }

    public void loadNewFavorite(String pPicture, String pBreed) {
        Map<String, Object> favorite = new HashMap<>();
        favorite.put("breed", pBreed);
        favorite.put("urlPicture", pPicture);
        favorite.put("timeStamp", new Date().toString());


        dbFavorites.collection("favorites")
                .add(favorite)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));


    }

    public void downloadAllFavorites() {
        List<Favorites> listFavorites = new ArrayList<>();
        dbFavorites.collection("favorites")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            Favorites favorite = setFavorite(document);
                            listFavorites.add(favorite);
                            Log.d(TAG, "onComplete: Lista Favoritos:a añadido " + favorite.toString());
                            Log.d(TAG, "onComplete: La lista tiene actualmente " + listFavorites.size() + " elementos");
                        }
                        Log.d(TAG, "onComplete: enviando lista favoritos al presenter" + listFavorites.toString());
                        Log.d(TAG, "onComplete: La lista tiene actualmente " + listFavorites.size() + " elementos");
                        favoritesPresenter.showFavorites(listFavorites);


                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }

                });

    }

    public boolean getFavorites() {

        dbFavorites.collection("favorites")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            Favorites favorite = setFavorite(document);
                            favoritesListToFilter.add(favorite);
                            Log.d(TAG, "onComplete IsFavorites: Lista Favoritos:a añadido " + favorite.toString());
                            Log.d(TAG, "onComplete isFavorites: La lista tiene actualmente " + favoritesListToFilter.size() + " elementos");
                        }



                    } else {
                        Log.w(TAG, "Error getting documents. isFavorites", task.getException());
                    }

                });
        return true;
    }


    private Favorites setFavorite(QueryDocumentSnapshot document) {
        Favorites favorite = new Favorites();
        favorite.setBreed(document.getString("breed"));
        favorite.setTimeStamp(document.getString("timeStamp"));
        favorite.setUrlImage(document.getString("urlPicture"));
        return favorite;
    }


    public boolean isFavorite(String url) {
        boolean result = true;

        if (getFavorites()) {
            Log.d(TAG, "isFavorite: Favoriteslist" + favoritesListToFilter.toString());
            List<String> filter = new ArrayList<>();
            for (Favorites favorite : favoritesListToFilter) {
                String addURL = favorite.getUrlImage();
                Log.d(TAG, "isFavorite: añadiendo URLs a filter" + addURL);
                filter.add(addURL);

            }
            Log.d(TAG, "isFavorite: URL a añadir" + url);
            Log.d(TAG, "isFavorite: Lista URL:" + filter);
            if (!filter.contains(url)) {
                result = false;
            }

        }
        Log.d(TAG, "isFavorite: result: " + result);
        return result;
    }
}
