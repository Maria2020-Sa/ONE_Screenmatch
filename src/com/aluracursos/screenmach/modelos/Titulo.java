package com.aluracursos.screenmach.modelos;

import java.time.LocalDate;

public class Titulo implements Comparable<Titulo> {
    private String nombre;
    private LocalDate fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private int sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;

    public Titulo(String nombre, LocalDate fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

   public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void muestraFichaTecnica(){
        System.out.println("""
                      Ficha Técnica  
                ***************************
                Nombre de la Película: %s
                Fecha de lanzamientos: %s
                Duración en minutos: %d minutos
                ****************************""".formatted(nombre, fechaDeLanzamiento.toString(), getDuracionEnMinutos()));
    }

    public void evalua (double nota){
        sumaDeLasEvaluaciones+=nota;
        totalDeEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones/totalDeEvaluaciones;
    }

    public String toString() {
        return "Nombre: "+nombre+", Fecha de lanzamiento: "+fechaDeLanzamiento;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }
}
