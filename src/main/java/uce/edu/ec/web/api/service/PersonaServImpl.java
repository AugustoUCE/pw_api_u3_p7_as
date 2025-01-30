package uce.edu.ec.web.api.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.web.api.repository.IPersonaRepo;
import uce.edu.ec.web.api.repository.model.Persona;
import uce.edu.ec.web.api.service.to.PersonaTO;

@ApplicationScoped
public class PersonaServImpl implements IPersonaServ {

    @Inject
    private IPersonaRepo personaRepo;

    @Override
    public PersonaTO buscarPorId(Integer id) {
        Persona pers = this.personaRepo.buscarPorId(id);
        return this.mapTo.apply(pers);
    }

    @Override
    public void guardar(PersonaTO persona) {
        this.personaRepo.insertar(this.mapPersona.apply(persona));
    }

    @Override
    public void actualizar(PersonaTO persona) {
        // vamos a convertir el objeto personaTO a persona por lambda
        Persona pers = this.mapPersona.apply(persona);
        this.personaRepo.actualizar(pers);
    }

    @Override
    public void eliminar(Integer id) {
        this.personaRepo.eliminar(id);
    }

    // declaracion de funciones
    private Function<Persona, PersonaTO> mapTo = p -> {
        PersonaTO personaTO = new PersonaTO(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());
        return personaTO;

    };
    private Function<PersonaTO, Persona> mapPersona = p -> {
        Persona persona = new Persona(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());
        return persona;

    };

}