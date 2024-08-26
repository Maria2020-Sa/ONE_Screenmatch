package com.aluracursos.screenmach.excepcion;

public class ErrorEnConversionDeDuracionException extends RuntimeException{
    private  String mensaje;

    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage(){
        return this.mensaje;
    }
}
