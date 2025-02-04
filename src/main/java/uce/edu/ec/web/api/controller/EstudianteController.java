package uce.edu.ec.web.api.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.web.api.service.IEstudianteServ;
import uce.edu.ec.web.api.service.to.EstudianteTO;


@ApplicationScoped
@Path("/estudiantes")
public class EstudianteController implements IEstudianteServ {

    @Inject
    private IEstudianteServ estudianteServ;

    @Path("/actualizar")
    @PUT
    @Override
    public void actualizar(EstudianteTO estudiante) {
    
        this.estudianteServ.actualizar(estudiante);
    }
    @Path("/buscar/{id}")
    @GET
    @Override
    public EstudianteTO buscarPorId(@PathParam("id") Integer id) {
        
        return this.estudianteServ.buscarPorId(id);
    }
    @Path("/eliminar/{id}")
    @DELETE 
    @Override

    public void eliminar(@PathParam("id") Integer id) {
        this.estudianteServ.eliminar(id);
    }
    @Path("/guardar")
    @POST
    @Override
    public void guardar(EstudianteTO estudiante) {
        
        this.estudianteServ.guardar(estudiante);
    }

    @Path("/actualizar/parcial")
    @PATCH
    public void actualizarParcial(EstudianteTO estudiante) {
        EstudianteTO tmp = this.estudianteServ.buscarPorId(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        tmp.setApellido(estudiante.getApellido());
        this.estudianteServ.actualizar(tmp);
    }

}
