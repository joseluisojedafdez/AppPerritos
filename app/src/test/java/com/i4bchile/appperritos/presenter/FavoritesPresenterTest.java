package com.i4bchile.appperritos.presenter;

import com.i4bchile.appperritos.model.Favorites;
import com.i4bchile.appperritos.model.Repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class FavoritesPresenterTest {

    @Mock
    private IFavoritesPresenterView favoriteView;
    @Mock
    private Repository repository;

    private List<Favorites> favoritesList;
    private FavoritesPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        presenter=new FavoritesPresenter(favoriteView,repository);
    }

    @Test
    public void showFavorites_emptyList() {
        //Given
        favoritesList=new ArrayList<>();
        //When
        favoriteView.showFavorites(favoritesList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoritesList);
    }
    @Test
    public void showFavorites_null() {
        //Given
        favoritesList=null;
        //When
        favoriteView.showFavorites(favoritesList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoritesList);
    }
    @Test
    public void showFavorites_listWithData() {
        //Given
        favoritesList=new ArrayList<>();
        Favorites favorite=new Favorites();
        favorite.setBreed("Akita");
        favorite.setUrlImage("imagen");
        favorite.setTimeStamp("timestamp");
        favoritesList.add(favorite);
        //When
        favoriteView.showFavorites(favoritesList);
        //Then
        Mockito.verify(favoriteView,Mockito.times(1)).showFavorites(favoritesList);
    }
}