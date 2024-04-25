package com.aluracursos.screenmach.calculos;

import com.aluracursos.screenmach.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int totalDeTiempo;

    public int getTotalDeTiempo() {
        return totalDeTiempo;
    }

    public void calcularTiempo(Titulo titulo){
        this.totalDeTiempo += titulo.getDuracionEnMinutos();
    }
}
