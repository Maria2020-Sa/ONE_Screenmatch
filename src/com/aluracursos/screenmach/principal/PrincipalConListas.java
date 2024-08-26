package com.aluracursos.screenmach.principal;

import com.aluracursos.screenmach.modelos.Pelicula;
import com.aluracursos.screenmach.modelos.Serie;
import com.aluracursos.screenmach.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula starWars = new Pelicula("Star Wars", 1977);
        starWars.evalua(6);
        Serie alquimia = new Serie("Alquimia de Almas",2023);
        Pelicula miPelicula = new Pelicula("I Robot",2024);
        miPelicula.evalua(10);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(starWars);
        lista.add(alquimia);

        for (Titulo items:lista) {
            System.out.println(items);
            if(items instanceof Pelicula pelicula && pelicula.getClasificacion()>2){
                System.out.println("Clasificación: "+pelicula.getClasificacion());
            }
        }

        ArrayList<String>listaDeArtistas=new ArrayList<>();
        listaDeArtistas.add("Cameron Díaz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Jhon Week");
        System.out.println("Lista de artistas no ordenada: "+listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas ordenada por nombre con Collections.sort(): "+listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de títulos ordenados por nombre: "+lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fechas: "+lista);
    }
}
