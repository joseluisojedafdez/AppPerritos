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
public class BreedPresenterTest {

    @Mock
    private IBreedPresenterView viewBreed;
    @Mock
    private Repository repository;

    private List<String> breeds;
    private BreedPresenter presenter;



    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new BreedPresenter(viewBreed, repository);
    }

    @Test
    public void showBreed_emptyList() {
        //Given
        breeds=new ArrayList<>();
        //When
        presenter.showBreed(breeds);
        //Then
        Mockito.verify(viewBreed,Mockito.times(1)).showBreed(breeds);


    }
    @Test
    public void showBreed_nullList() {
        //Given
        breeds=null;
        //When
        presenter.showBreed(breeds);
        //Then
        Mockito.verify(viewBreed,Mockito.times(1)).showBreed(breeds);


    }
    @Test
    public void showBreed_listWithData() {
        //Given
        breeds=new ArrayList<>();
        breeds.add("bkita");
        breeds.add("bulldog");
        //When
        presenter.showBreed(breeds);
        //Then
        Mockito.verify(viewBreed,Mockito.times(1)).showBreed(breeds);


    }
}