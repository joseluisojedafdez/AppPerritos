package com.i4bchile.appperritos.presenter;

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
public class PicturesPresenterTest {
    @Mock
    private IBreedPresenterView viewPicture;
    @Mock
    private AddFavorite addFavorite;
    @Mock
    private Repository repository;

    private String breed;

    private String picture;

    private List<String> breeds;
    private PicturesPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        presenter=new PicturesPresenter(viewPicture, addFavorite,repository,breed);
        picture="picture";
        breed="breed";
    }

    @Test
    public void showBreed_emptyList() {
        //Given
        breeds=new ArrayList<>();

        //When
        viewPicture.showBreed(breeds);
        //Then
        Mockito.verify(viewPicture,Mockito.times(1)).showBreed(breeds);
        Mockito.verify(repository,Mockito.never()).loadNewFavorite(picture,breed);

    }

    @Test
    public void showBreed_null() {
        //Given
        breeds=null;
        //When
        viewPicture.showBreed(breeds);
        //Then
        Mockito.verify(viewPicture,Mockito.times(1)).showBreed(breeds);
        Mockito.verify(repository,Mockito.never()).loadNewFavorite(picture,breed);

    }
    @Test
    public void showBreed_listWithValues() {
        //Given
        breeds=new ArrayList<>();
        breeds.add("akita");
        breeds.add("bulldog");
        //When
        viewPicture.showBreed(breeds);
        //Then
        Mockito.verify(viewPicture,Mockito.times(1)).showBreed(breeds);
        Mockito.verify(repository,Mockito.never()).loadNewFavorite(picture,breed);

    }
    @Test
    public void addFavorite_success() {
        //Given
        breeds=new ArrayList<>();

        //when
        presenter.addFavorite(picture,breed);
        Mockito.verify(repository,Mockito.times(1)).isFavorite(picture);
        Mockito.verify(repository,Mockito.times(1)).loadNewFavorite(picture,breed);
        Mockito.verify(addFavorite,Mockito.times(1)).showToast_Success();
        Mockito.verify(addFavorite,Mockito.never()).showToast_Failure();
        Mockito.verify(viewPicture,Mockito.never()).showBreed(breeds);

    }
    @Test
    public void addFavorite_failure() {
        //Given
        breeds=new ArrayList<>();
        Mockito.when(repository.isFavorite(picture)).thenReturn(true);
        //when
        presenter.addFavorite(picture,breed);

        Mockito.verify(repository,Mockito.times(1)).isFavorite(picture);
        Mockito.verify(repository,Mockito.never()).loadNewFavorite(picture,breed);
        Mockito.verify(addFavorite,Mockito.never()).showToast_Success();
        Mockito.verify(addFavorite,Mockito.times(1)).showToast_Failure();
        Mockito.verify(viewPicture,Mockito.never()).showBreed(breeds);

    }
}