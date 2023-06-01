package es.upsa.dasi.web.repository.impl;

import es.upsa.dasi.lol.FullLinea;
import es.upsa.dasi.lol.Linea;
import es.upsa.dasi.lol.exceptions.LineaException;
import es.upsa.dasi.web.daos.GatewayDao;
import es.upsa.dasi.web.repository.Repository;
import jakarta.inject.Inject;

import java.util.List;

public class RepositoryImpl implements Repository
{
    @Inject
    GatewayDao gatewayDao;

    @Override
    public List<Linea> requestLineas() throws LineaException {
        return gatewayDao.requestLineas();
    }

    @Override
    public FullLinea requestLineaByNombre(String nombre) throws Exception {
        return gatewayDao.requestLineaByNombre(nombre);
    }
}
