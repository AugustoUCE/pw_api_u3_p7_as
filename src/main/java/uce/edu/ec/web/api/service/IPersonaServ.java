package uce.edu.ec.web.api.service;

import uce.edu.ec.web.api.service.to.PersonaTO;

public interface IPersonaServ {
    public PersonaTO buscarPorId(Integer id);

    public void guardar(PersonaTO persona);

    public void actualizar(PersonaTO persona);

    public void eliminar(Integer id);
}
