package com.aluracursos.screenmach.modelos;

import java.time.LocalDate;

public class Titulo {
    private String nombre;
    private LocalDate fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private int sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }
    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
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
    public void setSumaDeLasEvaluaciones(int sumaDeLasEvaluaciones) {
        this.sumaDeLasEvaluaciones = sumaDeLasEvaluaciones;
    }
    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }
    public void setTotalDeEvaluaciones(int totalDeEvaluaciones) {
        this.totalDeEvaluaciones = totalDeEvaluaciones;
    }
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }
    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }
    public void setFecha(int anio, int mes, int dia){
        this.fechaDeLanzamiento = LocalDate.of(anio, mes, dia);
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
}
