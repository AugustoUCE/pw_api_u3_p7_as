package uce.edu.ec.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.web.api.repository.model.Persona;

@Transactional
@ApplicationScoped
public class PersonaRepoImpl implements IPersonaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    

    @Override
    public List<Persona> buscarNombre(String nombre) {

        
        TypedQuery<Persona>  myquery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre=:nombre ",Persona.class);
        myquery.setParameter("nombre", nombre);
        return myquery.getResultList();
    }

    @Override
    public List<Persona> buscarTodos() {
       
        
        TypedQuery<Persona>  myquery=this.entityManager.createQuery("SELECT p FROM Persona p ",Persona.class);
        return  myquery.getResultList();
    }

    public List<Persona> buscarNombreApellido(String nombre, String apellido ){
        TypedQuery<Persona> myquery =this.entityManager.createQuery(
            "SELECT p FROM Persona p WHERE p.nombre=:nombre AND p.apellido=:apellido ",Persona.class); 
            myquery.setParameter("nombre", nombre);
            myquery.setParameter("apellido", apellido);
            return myquery.getResultList();
    }
    @Override
    public Persona buscarPorId(Integer id) {
        try {
            Persona persona = this.entityManager.find(Persona.class, id);
            if (persona == null) {
                throw new RuntimeException("Persona no encontrada con el ID: " + id);
            }
            return persona;
        } catch (Exception e) {
            System.err.println("Error al buscar por id: " );
         
            return new Persona();
        }  
       
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
