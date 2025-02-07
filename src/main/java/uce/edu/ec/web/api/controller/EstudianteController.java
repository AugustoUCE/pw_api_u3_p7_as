package uce.edu.ec.web.api.controller;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.ec.web.api.service.IEstudianteServ;
import uce.edu.ec.web.api.service.to.EstudianteTO;

@ApplicationScoped
@Path("/estudiantes")
public class EstudianteController implements IEstudianteServ {

    @Inject
    private IEstudianteServ estudianteServ;

    @Path("/")
    @PUT
    @Override
    public void actualizar(EstudianteTO estudiante) {

        this.estudianteServ.actualizar(estudiante);
    }

    @GET
    @Path("/{id}")
    @Override
    public EstudianteTO buscarPorId(@PathParam("id") Integer id) {

        return this.estudianteServ.buscarPorId(id);
    }

    @GET
    @Path("/porNombre")
    @Override
    public List<EstudianteTO> buscarNombre(@QueryParam("nombre") String nombre) {
        // TODO Auto-generated method stub
        return this.estudianteServ.buscarNombre(nombre);
    }

    @GET
    @Path("/nombreApellido")
    @Override
    public List<EstudianteTO> buscarNombreApellido(@QueryParam("nombre") String nombre,
        @QueryParam("apellido") String apellido) {
        // TODO Auto-generated method stub
        return this.estudianteServ.buscarNombreApellido(nombre, apellido);
    }

    @Path("")
    @GET
    @Override
    public List<EstudianteTO> buscarTodos() {
        // TODO Auto-generated method stub
        return this.estudianteServ.buscarTodos();
    }

    @Path("/{id}")
    @DELETE
    @Override

    public void eliminar(@PathParam("id") Integer id) {
        this.estudianteServ.eliminar(id);
    }

    @Path("")
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
