package com.i4bchile.appperritos.presenter;

import android.util.Log;

import com.i4bchile.appperritos.model.IRepositoryPresenter;
import com.i4bchile.appperritos.model.data.Repository;

import java.util.List;

public class PicturesPresenter implements IRepositoryPresenter {

        private static final String TAG = "InfoLog";



    private IBreedPresenterView viewPicture;
    private Repository repository;
    private String breed;
    private AddFavorite addFavorite;

        public PicturesPresenter(IBreedPresenterView viewBreed, AddFavorite pAddFavorite, Repository repository, String pBreed) {
            this.viewPicture = viewBreed;
            this.repository = repository;
            this.addFavorite = pAddFavorite;
            this.breed=pBreed;
            Log.d(TAG, "PicturePresenter: seteando el presentador del repositorio");
            repository.setPicturesPresenter(this);
            Log.d(TAG, "PicturePresenter: llamando al método loadBreedList");
            repository.loadBreedPictures(breed);
            repository.getFavorites();
        }

        @Override
        public void showBreed(List<String> breeds) {
            Log.d(TAG, "showBreed: llamando a ShowBreed en PicturesPresenter"+breeds);
            viewPicture.showBreed(breeds);
        }


        public void addFavorite(String pPicture, String pBreed){

            if(!repository.isFavorite(pPicture)) {
                repository.loadNewFavorite(pPicture, pBreed);
                addFavorite.showToast_Success();

            }
            else {
                addFavorite.showToast_Failure();

            }
        }
    }

