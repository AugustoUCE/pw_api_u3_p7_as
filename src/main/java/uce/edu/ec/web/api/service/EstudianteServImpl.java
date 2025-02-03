package uce.edu.ec.web.api.service;

import java.util.function.Function;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.web.api.repository.IEstudianteRepo;
import uce.edu.ec.web.api.repository.model.Estudiante;
import uce.edu.ec.web.api.service.to.EstudianteTO;

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

}
