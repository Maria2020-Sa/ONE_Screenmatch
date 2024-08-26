package com.aluracursos.screenmach.principal;
import com.aluracursos.screenmach.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmach.modelos.Titulo;
import com.aluracursos.screenmach.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        //Configura un objeto Gson utilizando la biblioteca Gson para manejar la serialización
        // y deserialización de objetos Java a JSON y viceversa.
        // setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) establece la política
        // de nomenclatura de campos para que los nombres de los campos en el JSON sigan
        // la convención Upper Camel Case.
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting().create();

        while(true){
            System.out.println("Escriba el nombre de la película: ");
            var busqueda = lectura.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }
            String direccionUrl = "http://www.omdbapi.com/?t=" +
                    URLEncoder.encode(busqueda, StandardCharsets.UTF_8.toString()) +
                    "&apikey=d115e9ef";

            //Crear el request de la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccionUrl)).build();
            //Apertura del canal al cliente
            HttpClient client = HttpClient.newHttpClient();
            //Enviar la solicitud con client.send (y obtengo una respuesta que lo guardo en el response)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //De la respuesta extraigo el body
            String json = response.body();
            System.out.println(json);

            //Deserializar un objeto JSON en una instancia de la clase TituloOmdb.
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);

            try{
                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);
                titulos.add(miTitulo);
            }catch (NumberFormatException e){
                System.out.println("Ocurrió un error: ");
                System.out.println((e.getMessage()));
            }catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizó la ejecución del programa!");
    }
}