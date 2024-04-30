package com.aluracursos.screenmach.principal;

import com.aluracursos.screenmach.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmach.calculos.FiltroRecomendacion;
import com.aluracursos.screenmach.modelos.Episodio;
import com.aluracursos.screenmach.modelos.Pelicula;
import com.aluracursos.screenmach.modelos.Serie;
import com.aluracursos.screenmach.modelos.Titulo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Princial {
    public static void main(String[] args) {
        Pelicula starWars = new Pelicula("Star Wars", LocalDate.of(1977,5,25));
        starWars.setDuracionEnMinutos(121);
        starWars.setIncluidoEnElPlan(true);
        starWars.setDirector("Anaquin");

        starWars.muestraFichaTecnica();


        Serie alquimia = new Serie("Alquimia de Almas",LocalDate.of(2023,6,25));
        alquimia.setTemporadas(2);
        alquimia.setEpisodiosPorTemporada(16);
        alquimia.setMinutosPorEpisodio(120);

        alquimia.muestraFichaTecnica();


        Episodio belleza = new Episodio();
        belleza.setNombreEpisodio("Bellezas del reino");
        belleza.setNumeroEpisodio(1);
        belleza.setSerie(alquimia);
        belleza.setTotalVisualizaciones(10000);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.calcularTiempo(starWars);
        calculadora.calcularTiempo(alquimia);
        System.out.println("El total de minutos para ver todos los títulos es: " + calculadora.getTotalDeTiempo());


        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        starWars.evalua(8);
        starWars.evalua(6);
        starWars.evalua(10);
        System.out.println("La suma de las evalucaciones es: "+starWars.getSumaDeLasEvaluaciones());
        System.out.println("El total de evaluaciones es: "+starWars.getTotalDeEvaluaciones());
        System.out.println("El promedio de evaluaciones es: "+starWars.calculaMedia());

        filtroRecomendacion.filtra(starWars);
        filtroRecomendacion.filtra((belleza));


        Pelicula miPelicula = new Pelicula("I Robot",LocalDate.of(2024,4,26));
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setDirector("Yoyo");

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(starWars);
        lista.add(alquimia);

        System.out.println("Muestra tamaño de la lista: "+lista.size());
        System.out.println("Muestra elemento en el indice (0)"+lista.get(0));

        System.out.println("Lista de Titulos: "+lista.toString());
        System.out.println("Titulo en la posición (0): "+lista.get(1).toString());
    }
}