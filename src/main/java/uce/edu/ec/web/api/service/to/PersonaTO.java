package uce.edu.ec.web.api.service.to;

import java.time.LocalDateTime;




//@XmlRootElement
public class PersonaTO  {
    //private static final long serialVersionUID = -1544399202104638172L;
    private Integer id;

    private String nombre;

    private String apellido;
   
    private LocalDateTime fechaNacimiento;

    

    public PersonaTO() {
    }

    public PersonaTO(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

   // @XmlElement
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   // @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //@XmlElement
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   // @XmlElement
    //@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

  

    // SET AND GET

}
