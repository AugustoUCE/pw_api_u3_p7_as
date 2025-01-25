package uce.edu.ec.web.api.repository.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(generator = "persona_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
    @Column(name = "person_id")
    private IntegerConstant id;
    @Column(name = "person_nombre")
    private String nombre;
    @Column(name = "person_apellido")
    private String apellido;
    @Column(name = "person_fechaNacimiento")
    private LocalDateTime fechaNacimiento;

    // SET AND GET
    public IntegerConstant getId() {
        return id;
    }

    public void setId(IntegerConstant id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}