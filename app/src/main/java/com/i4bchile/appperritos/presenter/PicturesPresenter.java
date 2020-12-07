package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.model.IRepositoryPresenter;
import com.i4bchile.appperritos.model.Repository;

import java.util.List;

public class PicturesPresenter implements IRepositoryPresenter {

        private static final String TAG = "InfoLog";
        private IBreedPresenterView viewPicture;
        private Repository repository;
        private String breed;

        public PicturesPresenter(IBreedPresenterView viewBreed, Repository repository, String pBreed) {
            this.viewPicture = viewBreed;
            this.repository = repository;
            this.breed=pBreed;
            Log.d(TAG, "PicturePresenter: seteando el presentador del repositorio");
            repository.setPicturesPresenter(this);
            Log.d(TAG, "PicturePresenter: llamando al método loadBreedList");
            repository.loadBreedPictures(breed);
        }

        @Override
        public void showBreed(List<String> breeds) {
            Log.d(TAG, "showBreed: llamando a ShowBreed en PicturesPresenter"+breeds);
            viewPicture.showBreed(breeds);
        }
    }

