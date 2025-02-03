package uce.edu.ec.web.api.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.ec.web.api.service.IEstudianteServ;
import uce.edu.ec.web.api.service.to.EstudianteTO;


@ApplicationScoped
@Path("/estudiante")
public class EstudianteController implements IEstudianteServ {

    @Inject
    private IEstudianteServ estudianteServ;

    @Path("/actualizar")
    @PUT
    @Override
    public void actualizar(EstudianteTO estudiante) {
    
        this.estudianteServ.actualizar(estudiante);
    }
    @Path("/buscar")
    @GET
    @Override
    public EstudianteTO buscarPorId(Integer id) {
       
        return this.estudianteServ.buscarPorId(id);
    }
    @Path("/eliminar")
    @DELETE 
    @Override
    public void eliminar(Integer id) {
        this.estudianteServ.eliminar(id);
    }
    @Path("/guardar")
    @POST
    @Override
    public void guardar(EstudianteTO estudiante) {
        
        this.estudianteServ.guardar(estudiante);
    }

}
