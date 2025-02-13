package uce.edu.ec.web.api.controller;

import uce.edu.ec.web.api.service.IPersonaServ;
import uce.edu.ec.web.api.service.to.PersonaTO;
import jakarta.inject.Inject;
import java.util.*;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/personas") // servicio
public class PersonaController {

    // esto es una api web con implentacion restfull

    @Inject
    private IPersonaServ personaServ;

    @GET
    @Path("/{id}") // capacidad
    // configuracion el pathvariable reciba ese valor con si tipo con el argumento
    // del metodo
    //TIPO DE RESPUESTA  QUE SE VA A ENVIAR
    @Produces(MediaType.APPLICATION_XML)
    public Response buscarPorId(@PathParam("id") Integer id) {

        //los codigos se envia en las cabeceras de las paginas

        return Response.status(240).header("mensaje", "Persona creada pero en proceso de valición....").header("valor1", 500).entity(this.personaServ.buscarPorId(id)).build();
        //return this.personaServ.buscarPorId(id);
        // return Response.ok(this.personaServ.buscarPorId(id)).build();
    }

    @GET
    @Path("")

    public List<PersonaTO> buscarTodos() {
        return this.personaServ.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<PersonaTO> buscarNombre(@QueryParam("nombre") String nombre) {
        return this.personaServ.buscarNombre(nombre);
    }

    @GET
    @Path("/nombreApellido")
    public List<PersonaTO> buscarNombreApellido(@QueryParam("nombre") String nombre, @QueryParam("apellido") String apellido) {
        return this.personaServ.buscarNombreApellido(nombre, apellido);
    }

    @POST
    @Path("")
    public void guardar(PersonaTO persona) {
        this.personaServ.guardar(persona);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTO persona, @PathParam("id") Integer id) {
        persona.setId(id);
        this.personaServ.actualizar(persona);
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTO persona, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        // System.out.println(cedula);
        PersonaTO tmp = this.personaServ.buscarPorId(persona.getId());

        tmp.setNombre(persona.getNombre());
        this.personaServ.actualizar(tmp);
    }

    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id) {
        id = 1;
        this.personaServ.eliminar(id);
    }

}
