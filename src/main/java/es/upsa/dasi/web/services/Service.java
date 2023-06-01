package es.upsa.dasi.web.services;

import es.upsa.dasi.lol.FullLinea;
import es.upsa.dasi.lol.Linea;
import es.upsa.dasi.lol.exceptions.LineaException;

import java.util.List;

public interface Service
{
    public List<Linea> requestLineas() throws LineaException;

    public FullLinea requestLineaByNombre(String nombre) throws Exception;
}
