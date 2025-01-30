package uce.edu.ec.web.api.repository;

import uce.edu.ec.web.api.repository.model.Persona;

public interface IPersonaRepo {

    public Persona buscarPorId(Integer id);

    public void insertar(Persona persona);

    public void actualizar(Persona persona);

    public void eliminar(Integer id);

}