package uce.edu.ec.web.api.service;

import java.util.List;


import uce.edu.ec.web.api.service.to.PersonaTO;



public interface IPersonaServ {
    
    public PersonaTO buscarPorId(Integer id);
    public List<PersonaTO> buscarTodos();
    
    public List<PersonaTO> buscarNombre(String nombre);
    public List<PersonaTO> buscarNombreApellido(String nombre, String apellido );

    public void guardar(PersonaTO persona);

    public void actualizar(PersonaTO persona);

    public void eliminar(Integer id);

    
}
