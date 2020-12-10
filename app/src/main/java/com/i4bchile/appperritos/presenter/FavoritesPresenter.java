package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.model.Favorites;

import com.i4bchile.appperritos.model.Repository;

import java.util.List;

public class FavoritesPresenter  {
    private static final String TAG = "Infolog";
    private IFavoritesPresenterView favoriteView;
    private Repository repository;

    public FavoritesPresenter(IFavoritesPresenterView favoriteView, Repository repository) {
        this.favoriteView = favoriteView;
        this.repository = repository;
        repository.setFavoritesPresenter(this);
        repository.downloadAllFavorites();

    }


    public void showFavorites(List<Favorites> listFavorites) {

        Log.d(TAG, "showFavorites: en Presenter" + listFavorites.toString());
        favoriteView.showFavorites(listFavorites);
        Log.d(TAG, "showFavorites: en Presenter. La lista tiene "+listFavorites.size()+" elementos");
    }
}
