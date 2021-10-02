package com.example.trabajofinalv1.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@ToString
@Setter
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(generator = "secuenciaDePaciente", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secuenciaDePaciente", sequenceName = "BD_SECUENCIA_PACIENTE", allocationSize = 1)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="domicilio_id", nullable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(Long id, String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
