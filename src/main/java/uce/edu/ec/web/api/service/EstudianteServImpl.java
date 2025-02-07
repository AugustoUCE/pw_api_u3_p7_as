package uce.edu.ec.web.api.service;

import java.util.List;
import java.util.function.Function;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.web.api.repository.IEstudianteRepo;
import uce.edu.ec.web.api.repository.model.Estudiante;
import uce.edu.ec.web.api.service.to.EstudianteTO;
import java.util.ArrayList;

@ApplicationScoped
public class EstudianteServImpl implements IEstudianteServ {

    @Inject
    private IEstudianteRepo estudianteRepo;

    @Override
    public void actualizar(EstudianteTO estudiante) {
        Estudiante est = this.mapEstudiante.apply(estudiante);
        this.estudianteRepo.actualizar(est);
    }

    @Override
    public EstudianteTO buscarPorId(Integer id) {
        Estudiante est = this.estudianteRepo.buscarPorId(id);
        return this.mapTo.apply(est);
    }

    

    @Override
    public List<EstudianteTO> buscarNombre(String nombre) {
        
       

        return this.mapToList.apply(this.estudianteRepo.buscarNombre(nombre));
    }

    @Override
    public List<EstudianteTO> buscarNombreApellido(String nombre, String apellido) {
        // TODO Auto-generated method stub
        return this.mapToList.apply(this.estudianteRepo.buscarNombreApellido(nombre, apellido));
    }

    @Override
    public List<EstudianteTO> buscarTodos() {
        // TODO Auto-generated method stub
        return this.mapToList.apply(this.estudianteRepo.buscarTodos());
    }

    @Override
    public void eliminar(Integer id) {

        this.estudianteRepo.eliminar(id);

    }

    @Override
    public void guardar(EstudianteTO estudiante) {

        Estudiante est = this.mapEstudiante.apply(estudiante);
        this.estudianteRepo.insertar(est);

    }

    // funciones
    // recibir datos de la base de datos y convertirlos a un to
    private Function<Estudiante, EstudianteTO> mapTo = e -> {
        EstudianteTO estud = new EstudianteTO(e.getId(), e.getNombre(), e.getApellido(), e.getTelefono(), e.getCodigo(),
                e.getFechaNacimiento());
        return estud;
    };

    // enviar datos a un to y convertirlos a la base de datos
    private Function<EstudianteTO, Estudiante> mapEstudiante = e -> {
        Estudiante estud = new Estudiante(e.getId(), e.getNombre(), e.getApellido(), e.getTelefono(), e.getCodigo(),
                e.getFechaNacimiento());
        return estud;
    };

    //meth par alist
  

    private Function<List<Estudiante>, List<EstudianteTO>> mapToList = (e) -> {
        return e.stream().map(this.mapTo).toList();
    };
}
