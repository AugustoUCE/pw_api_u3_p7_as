package uce.edu.ec.web.api.service;
import  uce.edu.ec.web.api.service.to.EstudianteTO;

public interface IEstudianteServ {
    public void guardar(EstudianteTO estudiante);

    public void actualizar(EstudianteTO estudiante);

    public void eliminar(Integer id);

    public EstudianteTO buscarPorId(Integer id);
}