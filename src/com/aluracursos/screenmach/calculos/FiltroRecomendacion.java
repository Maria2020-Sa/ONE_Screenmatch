package com.aluracursos.screenmach.calculos;

public class FiltroRecomendacion{

    public void filtra(Clasificable clasificable){
        if (clasificable.getClasificacion() >= 4){
            System.out.println("Evaluación más alta, muy recomendado.");
        } else if (clasificable.getClasificacion() >= 2) {
            System.out.println("Popular en el momento.");
        }else
            System.out.println("Guardalo para ver más tarde.");
    }
}
