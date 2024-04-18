package com.example.excepcion;

public class RecursoNoEncontradoExepction extends RuntimeException {
    public RecursoNoEncontradoExepction(String mensaje){
        super(mensaje);
    }
}
