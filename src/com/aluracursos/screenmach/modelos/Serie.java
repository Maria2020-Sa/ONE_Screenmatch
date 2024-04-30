package com.aluracursos.screenmach.modelos;

import com.aluracursos.screenmach.calculos.Clasificable;

import java.time.LocalDate;

public class Serie extends Titulo implements Clasificable {
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private int cantidadDeVistas;

    public Serie(String nombre, LocalDate fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }


    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public void setCantidadDeVistas(int cantidadDeVistas) {
        this.cantidadDeVistas = cantidadDeVistas;
    }

    @Override
    public int getDuracionEnMinutos() {
        return this.temporadas * this.episodiosPorTemporada * this.minutosPorEpisodio;
    }

    @Override
    public int getClasificacion() {
        if (cantidadDeVistas > 100) {
            return 4;
        }else{
            return 2;
        }
    }
}
