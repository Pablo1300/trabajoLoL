package es.upsa.dasi.web.daos.impl;

import es.upsa.dasi.lol.FullLinea;
import es.upsa.dasi.lol.Linea;
import es.upsa.dasi.lol.NombresAdapter;
import es.upsa.dasi.lol.exceptions.LineaException;
import es.upsa.dasi.lol.exceptions.LineaNotFoundException;
import es.upsa.dasi.lol.exceptions.PersonajeException;
import es.upsa.dasi.web.daos.GatewayDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class GatewayDaoImpl implements GatewayDao
{
    @Override
    public List<Linea> requestLineas() throws LineaException
    {
        Response response = ClientBuilder.newBuilder()
                                         .build()
                                         .target("http://localhost:8084/lineas")
                                         .request(MediaType.APPLICATION_JSON_TYPE)
                                         .get();

        switch ( response.getStatus() )
        {
            case 200:   return response.readEntity( new GenericType<List<Linea>>() {}  );

            default:    throw new LineaException("Error no hay lineas disponibles");
        }
    }

    @Override
    public FullLinea requestLineaByNombre(String nombre) throws Exception
    {
        Response response = ClientBuilder.newBuilder()
                                         .build()
                                         .target("http://localhost:8084/lineas/{nombre}")
                                         .resolveTemplate("nombre", nombre)
                                         .request(MediaType.APPLICATION_JSON_TYPE)
                                         .get();

        nombre = NombresAdapter.obtenerNombreFormato(nombre);

        switch ( response.getStatus() )
        {
            case 200:   return response.readEntity(FullLinea.class);

            case 404:   throw new LineaNotFoundException(nombre);

            default:    throw new PersonajeException("Error en la obtención de la línea " + nombre);
        }
    }
}
