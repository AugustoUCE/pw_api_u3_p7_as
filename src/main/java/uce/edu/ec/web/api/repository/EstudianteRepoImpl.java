package uce.edu.ec.web.api.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.web.api.repository.model.Estudiante;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Typed;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.entityManager.merge(estudiante);
    }

    @Override
    public Estudiante buscarPorId(Integer id) {

        return this.entityManager.find(Estudiante.class, id);
    }

    public List<Estudiante> buscarTodos() {
        return this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    };

    public List<Estudiante> buscarNombre(String nombre) {
        TypedQuery<Estudiante> myquery = this.entityManager.createQuery(
                "SELECT e FROM Estudiante e WHERE e.nombre = :nombre", Estudiante.class);
        myquery.setParameter("nombre", nombre);

        return myquery.getResultList();

    };

    public List<Estudiante> buscarNombreApellido(String nombre, String apellido) {

        TypedQuery<Estudiante> myquery = this.entityManager.createQuery(
                "SELECT e FROM Estudiante e WHERE e.nombre = :nombre AND e.apellido = :apellido", Estudiante.class);
        myquery.setParameter("nombre", nombre);
        myquery.setParameter("apellido", apellido);
        return myquery.getResultList();
    };

    @Override
    public void eliminar(Integer id) {

        this.entityManager.remove(this.buscarPorId(id));
    }

    @Override
    public void insertar(Estudiante estudiante) {

        this.entityManager.persist(estudiante);

    }

}
