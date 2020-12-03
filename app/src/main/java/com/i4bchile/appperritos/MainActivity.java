package com.i4bchile.appperritos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*TODO

    [] PARTE 1 MODELO
       [] Creación de los POJOS (RazaLista, RazaImagen,Favoritos)
       [] Crear item_list_xxx.xml (detalle de cada elemento para cada lista)
       [] Crear los fragmentos necesarios: Listado de Razas, Detalles, Listado de Favoritos
       [] Mostrar en cada fragmento el Recyclerview correspondiente
       [] Crear los adapters que sean necesarios

    [] PARTE 2 CONSUMO Y MUESTRA INFORMACIÓN
        [] Crear el Cliente Retrofit y la interface necesaria para la conexión
        [] Realizar la conexión a la API
        [] Crear el presentador para cada vista. Crear las interfaces correspondientes
        [] IMplementar los métodos de las interfaces en las vistas
        [] Instanciar los adaptadores donde sean necesario y pasar los datasets que necesite cada uno de ellos

    [] PARTE 3 GUARDAR FAVORITOS USANDO FIRESTORE

        [] Implementar la funcionalidad para que al hacer longClick este lleve los datos a FireStore
        [] Mostrar el detalle de los favoritos en un fragmento de detalles

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}