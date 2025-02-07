package uce.edu.ec.web.api.service;

import java.util.List;
import uce.edu.ec.web.api.service.to.EstudianteTO;

public interface IEstudianteServ {
    public void guardar(EstudianteTO estudiante);

    public void actualizar(EstudianteTO estudiante);

    public void eliminar(Integer id);

    public EstudianteTO buscarPorId(Integer id);

    public List<EstudianteTO> buscarTodos();

    public List<EstudianteTO> buscarNombre(String nombre);

    public List<EstudianteTO> buscarNombreApellido(String nombre, String apellido);
}