package uce.edu.ec.web.api.repository;

import uce.edu.ec.web.api.repository.model.Estudiante;

public interface IEstudianteRepo {

    public void insertar (Estudiante estudiante);
    public void actualizar (Estudiante estudiante);
    public void eliminar (Integer id);
    public Estudiante buscarPorId (Integer id);



}
