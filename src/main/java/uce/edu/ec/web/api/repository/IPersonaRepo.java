package uce.edu.ec.web.api.repository;

import java.util.List;

import uce.edu.ec.web.api.repository.model.Persona;

public interface IPersonaRepo {

    public Persona buscarPorId(Integer id);

    public List<Persona> buscarTodos();

    public List<Persona> buscarNombre(String nombre);
    public List<Persona> buscarNombreApellido(String nombre, String apellido );

    public void insertar(Persona persona);

    public void actualizar(Persona persona);

    public void eliminar(Integer id);

    

}