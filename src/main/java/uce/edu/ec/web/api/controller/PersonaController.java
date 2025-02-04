package uce.edu.ec.web.api.controller;

import uce.edu.ec.web.api.service.IPersonaServ;
import uce.edu.ec.web.api.service.to.PersonaTO;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/personas") // servicio
public class PersonaController {

    // esto es una api web con implentacion restfull

    @Inject
    private IPersonaServ personaServ;

    @GET
    @Path("/buscar/{id}") // capacidad
   
    public PersonaTO buscarPorId( @PathParam("id") Integer id) {
        
        return this.personaServ.buscarPorId(id);
        // return Response.ok(this.personaServ.buscarPorId(id)).build();
    }

    @POST
    @Path("/guardar")
    public void guardar(PersonaTO persona) {
        this.personaServ.guardar(persona);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(PersonaTO persona) {
        this.personaServ.actualizar(persona);
    }

    @PATCH
    @Path("/actualizarParcial")
    public void actualizarParcial(PersonaTO persona) {
        PersonaTO tmp = this.personaServ.buscarPorId(persona.getId());

        tmp.setNombre(persona.getNombre());
        this.personaServ.actualizar(tmp);
    }

    @DELETE
    @Path("/eliminar")
    public void eliminar(Integer id) {
         id = 1;
        this.personaServ.eliminar(id);
    }

}
