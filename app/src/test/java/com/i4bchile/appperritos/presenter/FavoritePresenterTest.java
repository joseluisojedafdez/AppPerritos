package com.i4bchile.appperritos.presenter;

import com.i4bchile.appperritos.model.Favorite;
import com.i4bchile.appperritos.model.data.Repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FavoritePresenterTest {

    @Mock
    private IFavoritesPresenterView favoriteView;
    @Mock
    private Repository repository;

    private List<Favorite> favoriteList;
    private FavoritesPresenter presenter;

    @Before
    public void setUp()  {
        MockitoAnnotations.openMocks(this);
        presenter=new FavoritesPresenter(favoriteView,repository);
    }

    @Test
    public void showFavorites_emptyList() {
        //Given
        favoriteList =new ArrayList<>();
        //When
        favoriteView.showFavorites(favoriteList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoriteList);
    }
    @Test
    public void showFavorites_null() {
        //Given
        favoriteList =null;
        //When
        favoriteView.showFavorites(favoriteList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoriteList);
    }
    @Test
    public void showFavorites_listWithData() {
        //Given
        favoriteList =new ArrayList<>();
        Favorite favorite=new Favorite();
        favorite.setBreed("Akita");
        favorite.setUrlImage("imagen");
        favorite.setTimeStamp("timestamp");
        favoriteList.add(favorite);
        //When
        favoriteView.showFavorites(favoriteList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoriteList);
    }
}