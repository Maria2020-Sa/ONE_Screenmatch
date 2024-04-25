import com.aluracursos.screenmach.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmach.calculos.Clasificable;
import com.aluracursos.screenmach.calculos.FiltroRecomendacion;
import com.aluracursos.screenmach.modelos.Episodio;
import com.aluracursos.screenmach.modelos.Pelicula;
import com.aluracursos.screenmach.modelos.Serie;

import java.time.LocalDate;
import java.time.Month;

public class Princial {
    public static void main(String[] args) {
        Pelicula starWars = new Pelicula();
        Serie alquimia = new Serie();
        Episodio belleza = new Episodio();
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();

        starWars.setNombre("Star Wars");
        starWars.setFecha(1977,5,25);
        starWars.setFechaDeLanzamiento(LocalDate.of(1977,Month.MAY, 23));
        starWars.setDuracionEnMinutos(121);
        starWars.setIncluidoEnElPlan(true);

        alquimia.setNombre("Alquimia de Almas");
        alquimia.setTemporadas(2);
        alquimia.setEpisodiosPorTemporada(16);
        alquimia.setMinutosPorEpisodio(120);
        alquimia.setFechaDeLanzamiento(LocalDate.of(2023, Month.SEPTEMBER,25));

        belleza.setNombreEpisodio("Bellezas del reino");
        belleza.setNumeroEpisodio(1);
        belleza.setSerie(alquimia);
        belleza.setTotalVisualizaciones(10000);

        starWars.muestraFichaTecnica();
        alquimia.muestraFichaTecnica();

        calculadora.calcularTiempo(starWars);
        calculadora.calcularTiempo(alquimia);
        System.out.println("El total de tiempo para ver todos los títulos es: " + calculadora.getTotalDeTiempo());

        starWars.evalua(8);
        starWars.evalua(6);
        starWars.evalua(10);
        System.out.println("La suma de las evalucaciones es: "+starWars.getSumaDeLasEvaluaciones());
        System.out.println("El total de evaluaciones es: "+starWars.getTotalDeEvaluaciones());
        System.out.println("El promedio de evaluaciones es: "+starWars.calculaMedia());

        filtroRecomendacion.filtra(starWars);
        filtroRecomendacion.filtra((belleza));

    }
}