package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.model.Favorites;
import com.i4bchile.appperritos.model.IRepositoryPresenter;
import com.i4bchile.appperritos.model.Repository;

import java.util.List;

public class BreedPresenter implements IRepositoryPresenter {
    private static final String TAG = "InfoLog";
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
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: llamando a ShowBreed en Presenter" + breeds);
        viewBreed.showBreed(breeds);
    }


}
