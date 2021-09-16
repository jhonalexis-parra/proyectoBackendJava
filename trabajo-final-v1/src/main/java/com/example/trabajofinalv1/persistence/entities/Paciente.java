package com.example.trabajofinalv1.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate fechaIngreso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="domicilio_id", nullable = false)
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    public Paciente(String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente() {
    }
}
