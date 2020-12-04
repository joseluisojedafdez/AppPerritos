package com.i4bchile.appperritos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.i4bchile.appperritos.R;
import com.i4bchile.appperritos.presenter.BreedPresenter;

public class MainActivity extends AppCompatActivity {

    /*TODO

    [] PARTE 1 MODELO
       [x] Creación de los POJOS (RazaLista, RazaImagen,Favoritos)
       [] Crear item_list_xxx.xml (detalle de cada elemento para cada lista)
       [] Crear los fragmentos necesarios:
               [] Listado de Razas
               [] Detalles
               [] Listado de Favoritos
       [] Mostrar en cada fragmento el Recyclerview correspondiente

       [] Crear los adapters que sean necesarios
            [] Adapter para Breed
            [] Adapter para BreedImage
            [] Adapter para Favorites

    [] PARTE 2 CONSUMO Y MUESTRA INFORMACIÓN
        [x] Añadir dependencias de Retrofit
        [x] Crear el Cliente Retrofit y la interface necesaria para la conexión
        [x] Realizar la conexión a la API
        [x] Añadir permisos de internet en el Manifest
        [X] Activar viewBinding
        [] Crear el presentador para cada vista. Crear las interfaces correspondientes
            [] Crear el presentador para Breed
            [] Crear el presentador para BreedImage
            [] Crear el presentador para Favorites
        [] IMplementar los métodos de las interfaces en las vistas
            [] implementar metodos Breed
            [] implementar metodos BreedImage
            [] implementar metodos Favorites

        [] Instanciar los adaptadores donde sean necesario y pasar los datasets que necesite cada uno de ellos


    [] PARTE 3 GUARDAR FAVORITOS USANDO FIRESTORE

        [] Implementar la funcionalidad para que al hacer longClick este lleve los datos a FireStore
        [] Mostrar el detalle de los favoritos en un fragmento de detalles

     */

    BreedPresenter presenter=new BreedPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.lodadBreedList();
    }
}