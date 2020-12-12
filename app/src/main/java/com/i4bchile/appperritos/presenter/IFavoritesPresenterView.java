package com.i4bchile.appperritos.presenter;

import com.i4bchile.appperritos.model.Favorite;

import java.util.List;

public interface IFavoritesPresenterView {



    void showFavorites(List<Favorite> listFavorites);
}
