package com.example.trabajofinalv1.model;

import com.example.trabajofinalv1.persistence.entities.Paciente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PacienteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private DomicilioDto domicilio;

    public PacienteDto() {
    }

    public PacienteDto(String nombre, String apellido, String dni, Date fechaIngreso, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public PacienteDto(Paciente p){
        id = p.getId();
        nombre = p.getNombre();
        apellido = p.getApellido();
        dni = p.getDni();
        fechaIngreso = p.getFechaIngreso();
        domicilio = new DomicilioDto(p.getDomicilio());
    }

    public Paciente toEntity(){
        Paciente entity = new Paciente();

        entity.setId(id);
        entity.setApellido(apellido);
        entity.setDni(dni);
        entity.setNombre(nombre);
        entity.setFechaIngreso(fechaIngreso);
        entity.setDomicilio(domicilio.toEntity());

        return entity;
    }

}
