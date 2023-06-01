package es.upsa.dasi.web.services.impl;

import es.upsa.dasi.lol.FullLinea;
import es.upsa.dasi.lol.Linea;
import es.upsa.dasi.lol.exceptions.LineaException;
import es.upsa.dasi.web.repository.Repository;
import es.upsa.dasi.web.services.Service;
import jakarta.inject.Inject;

import java.util.List;

public class ServiceImpl implements Service
{
    @Inject
    Repository repository;

    @Override
    public List<Linea> requestLineas() throws LineaException {
        return repository.requestLineas();
    }

    @Override
    public FullLinea requestLineaByNombre(String nombre) throws Exception {
        return repository.requestLineaByNombre(nombre);
    }
}
