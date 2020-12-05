package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.model.IRepositoryPresenter;
import com.i4bchile.appperritos.model.Repository;

public class BreedPresenter implements IRepositoryPresenter {
    private static final String TAG = "BreedListPresenter";
    private IBreedPresenterView viewBreed;
    private Repository repository;

    public BreedPresenter(IBreedPresenterView viewBreed, Repository repository) {
        this.viewBreed = viewBreed;
        this.repository = repository;
        Log.d(TAG, "BreedPresenter: seteando el presentador del repositorio");
        repository.setBreedPresenter(this);
        Log.d(TAG, "BreedPresenter: llamando al método loadBreedList");
        repository.lodadBreedList();
    }

    @Override
    public void showBreed() {
        Log.d(TAG, "showBreed: llamando a ShowBreed en Presenter");
    }
}
