package com.i4bchile.appperritos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.databinding.ActivityMainBinding;
import com.i4bchile.appperritos.model.Repository;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.FavoritesPresenter;
import com.i4bchile.appperritos.presenter.IBreedPresenterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IBreedPresenterView, OnItemClickListener {

    private static final String TAG ="InfoLog";
    private ActivityMainBinding binding;


    /*TODO

    [x] PARTE 1 MODELO
       [x] Creación de los POJOS (RazaLista, RazaImagen,Favoritos)
       [x] Crear item_list_xxx.xml (detalle de cada elemento para cada lista)
            [x] item_list_breed.xml
            [x] item_list_images.xml
            [x] item_list_favorites.xml

       [x] Crear los fragmentos necesarios:
               [x] Listado de Razas (mainActivity)
               [x] Detalles
               [x] Listado de Favoritos
       [x] Mostrar en cada fragmento el Recyclerview correspondiente
                [x] RecyclerView Breed en Main Activity
                [x] RecyclerView Detalles en BreedFragmentView
                [x] Recyclerview Favorites en FavoritesFragmentView

       [x] Crear los adapters que sean necesarios
            [x] Adapter para Breed
            [x] Adapter para BreedImage
            [x] Adapter para Favorites

    [x] PARTE 2 CONSUMO Y MUESTRA INFORMACIÓN
        [x] Añadir dependencias de Retrofit
        [x] Crear el Cliente Retrofit y la interface necesaria para la conexión
        [x] Realizar la conexión a la API
        [x] Añadir permisos de internet en el Manifest
        [X] Activar viewBinding
        [x] Crear el presentador para cada vista. Crear las interfaces correspondientes
            [x] Crear el presentador para Breed
            [x] Crear el presentador para BreedImage
            [x] Crear el presentador para Favorites
        [x] IMplementar los métodos de las interfaces en las vistas
            [x] implementar metodos Breed
            [x] implementar metodos BreedImage
            [x] implementar metodos Favorites

        [x] Instanciar los adaptadores donde sean necesario y pasar los datasets que necesite cada uno de ellos
            [x] instanciar y actualizar BreedAdapter
            [x] instanciaar y actualizar BreedImageAdapter
            [x] instanciar y actualizar FavoritesAdapter


    [x] PARTE 3 GUARDAR FAVORITOS USANDO FIRESTORE

        [x] Implementar la funcionalidad para que al hacer longClick este lleve los datos a FireStore
        [x] Mostrar el detalle de los favoritos en un fragmento de detalles

     */

    BreedPresenter presenter;
    private BreedAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        adapter=new BreedAdapter(new ArrayList<>(),this);
        presenter = new BreedPresenter(this,new Repository());
        Log.d(TAG, "onCreate: construyendo adaptador y Recyclerview");
        RecyclerView recyclerview = binding.rvBreedRecycler;
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        recyclerview.setAdapter(adapter);
        Button viewFavorites = binding.btViewFavorites;
        viewFavorites.setOnClickListener(v -> getSupportFragmentManager().
                beginTransaction().
                replace(R.id.frame_recyclerview,FavoritesFragment.newInstance("","")).
                addToBackStack("Detail").
                commit());

    }

    @Override
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: Actualizando lista de breeds en el adapter");
        adapter.updateBreeds(breeds);
    }


    @Override
    public void onClick(int position) {
        Log.d(TAG, "onClick: haciendo click en el elemento de la lista"+adapter.getListOfBreeds().get(position));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_recyclerview,PicturesFragment.newInstance("",adapter.getListOfBreeds().get(position))).addToBackStack("Detail").commit();

    }
}