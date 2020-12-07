package com.i4bchile.appperritos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.model.Repository;
import com.i4bchile.appperritos.presenter.BreedPresenter;
import com.i4bchile.appperritos.presenter.IBreedPresenterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IBreedPresenterView, OnItemClickListener {

    private static final String TAG ="InfoLog";

    /*TODO

    [] PARTE 1 MODELO
       [x] Creación de los POJOS (RazaLista, RazaImagen,Favoritos)
       [] Crear item_list_xxx.xml (detalle de cada elemento para cada lista)
            [] item_list_breed.xml
            [] item_list_images.xml
            [] item_list_favorites.xml

       [] Crear los fragmentos necesarios:
               [] Listado de Razas (mainActivity)
               [] Detalles
               [] Listado de Favoritos
       [] Mostrar en cada fragmento el Recyclerview correspondiente
                [] RecyclerView Breed en Main Activity
                [] RecyclerView Detalles en BreedFragmentView
                [] Recyclerview Favorites en FavoritesFragmentView

       [] Crear los adapters que sean necesarios
            [x] Adapter para Breed
            [] Adapter para BreedImage
            [] Adapter para Favorites

    [] PARTE 2 CONSUMO Y MUESTRA INFORMACIÓN
        [x] Añadir dependencias de Retrofit
        [x] Crear el Cliente Retrofit y la interface necesaria para la conexión
        [x] Realizar la conexión a la API
        [x] Añadir permisos de internet en el Manifest
        [X] Activar viewBinding
        [] Crear el presentador para cada vista. Crear las interfaces correspondientes
            [x] Crear el presentador para Breed
            [] Crear el presentador para BreedImage
            [] Crear el presentador para Favorites
        [] IMplementar los métodos de las interfaces en las vistas
            [x] implementar metodos Breed
            [] implementar metodos BreedImage
            [] implementar metodos Favorites

        [] Instanciar los adaptadores donde sean necesario y pasar los datasets que necesite cada uno de ellos
            [x] instanciar y actualizar BreedAdapter
            [] instanciaar y actualizar BreedImageAdapter
            [] instanciar y actualizar FavoritesAdapter


    [] PARTE 3 GUARDAR FAVORITOS USANDO FIRESTORE

        [] Implementar la funcionalidad para que al hacer longClick este lleve los datos a FireStore
        [] Mostrar el detalle de los favoritos en un fragmento de detalles

     */

    BreedPresenter presenter;
    private BreedAdapter adapter;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new BreedAdapter(new ArrayList<>(),this);
        presenter = new BreedPresenter(this,new Repository());
        Log.d(TAG, "onCreate: construyendo adaptador y Recyclerview");
        recyclerview=findViewById(R.id.rv_breed_recycler);
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        recyclerview.setAdapter(adapter);

    }

    @Override
    public void showBreed(List<String> breeds) {
        Log.d(TAG, "showBreed: Actualizando lista de breeds en el adapter");
        adapter.updateBreeds(breeds);
    }


    @Override
    public void onClick(int position) {
        Log.d(TAG, "onClick: haciendo click en el elemento de la lista"+adapter.getListOfBreeds().get(position));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_recyclerview,PicturesFragment.newInstance("",adapter.getListOfBreeds().get(position))).commit();

    }
}