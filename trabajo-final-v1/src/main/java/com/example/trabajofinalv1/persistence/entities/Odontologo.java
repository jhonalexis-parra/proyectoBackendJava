package com.example.trabajofinalv1.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Odontologo implements Serializable {

    // TODO eliminar sequenceName
    @Id
    @GeneratedValue(generator = "secuenciaDeOdontologo", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="secuenciaDeOdontologo", sequenceName="BD_SECUENCIA_ODONTOLOGO", allocationSize=1)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo() {
    }
}
