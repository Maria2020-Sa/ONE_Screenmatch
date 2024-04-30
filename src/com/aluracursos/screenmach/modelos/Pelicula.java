package com.aluracursos.screenmach.modelos;

import com.aluracursos.screenmach.calculos.Clasificable;

import java.time.LocalDate;

public class Pelicula extends Titulo implements Clasificable{
    private String director;

    public Pelicula(String nombre, LocalDate fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int)(calculaMedia()/2);
    }
}
