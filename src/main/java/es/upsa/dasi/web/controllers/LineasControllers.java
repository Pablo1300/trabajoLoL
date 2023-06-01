package es.upsa.dasi.web.controllers;

import es.upsa.dasi.lol.Linea;
import es.upsa.dasi.lol.exceptions.LineaException;
import es.upsa.dasi.web.services.Service;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Path("lineas")
public class LineasControllers
{
    @Inject
    Service service;

    @Inject
    Models models;

    @GET
    @Controller

    public Response getLineas() throws LineaException
    {
        List<Linea> lineas = service.requestLineas();
        models.put("lineas", lineas);

        return Response.ok()
                .entity("/jsps/lineas.jsp")
                .build();
    }
}
