package uce.edu.ec.web.api.repository;

import uce.edu.ec.web.api.repository.model.Estudiante;

import java.util.List;  

public interface IEstudianteRepo {

    public void insertar (Estudiante estudiante);
    public void actualizar (Estudiante estudiante);
    public void eliminar (Integer id);
    public Estudiante buscarPorId (Integer id);
    public List<Estudiante> buscarTodos();
    public List<Estudiante> buscarNombre(String nombre);
    public List<Estudiante> buscarNombreApellido (String nombre, String apellido);



}
