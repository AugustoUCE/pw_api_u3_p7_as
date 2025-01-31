package uce.edu.ec.web.api.controller;

import uce.edu.ec.web.api.service.IPersonaServ;
import uce.edu.ec.web.api.service.to.PersonaTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;


@Path("/personas") // servicio
public class PersonaController {

    // esto es una api web con implentacion restfull

    @Inject
    private IPersonaServ personaServ;

    @GET
    @Path("/buscar") // capacidad
    public PersonaTO buscarPorId() {
        Integer id = 1;
        return this.personaServ.buscarPorId(id);
        //return Response.ok(this.personaServ.buscarPorId(id)).build();
    }

    public void guardar(PersonaTO persona) {
        this.personaServ.guardar(persona);
    }

    public void actualizar(PersonaTO persona) {
        this.personaServ.actualizar(persona);
    }

    public void eliminar(Integer id) {
        this.personaServ.eliminar(id);
    }

}
