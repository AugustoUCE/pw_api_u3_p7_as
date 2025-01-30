package uce.edu.ec.web.api.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.ec.web.api.repository.model.Persona;

@Transactional
@ApplicationScoped
public class PersonaRepoImpl implements IPersonaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona buscarPorId(Integer id) {
        return this.entityManager.find(Persona.class, id);
    }

    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer id) {

        this.entityManager.remove(this.buscarPorId(id));
    }

}
