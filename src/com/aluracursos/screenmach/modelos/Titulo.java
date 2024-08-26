package com.aluracursos.screenmach.modelos;

import com.aluracursos.screenmach.excepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    private String nombre;
    private int fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private int sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        // Obtener el año desde el campo year del objeto miTituloOmdb
        String yearString = miTituloOmdb.year();
        // Dividir la cadena usando una expresión regular que maneja diferentes tipos de guiones
        String[] years = yearString.split("[–-]");
        // Tomar el primer año y convertirlo a entero
        this.fechaDeLanzamiento = Integer.parseInt(years[0].trim());
        if(miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir " +
                    "la duración, porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(
                miTituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }

    public String getNombre() {
        return nombre;
    }
    public int getFechaDeLanzamiento() {
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
                ****************************""".formatted(nombre, fechaDeLanzamiento, getDuracionEnMinutos()));
    }

    public void evalua (double nota){
        sumaDeLasEvaluaciones+=nota;
        totalDeEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones/totalDeEvaluaciones;
    }

    public String toString() {
        return "(Nombre: " + nombre + ", " +
                "Fecha de lanzamiento: " + fechaDeLanzamiento + ", " +
                "Duración: " + duracionEnMinutos + ")";
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }
}
