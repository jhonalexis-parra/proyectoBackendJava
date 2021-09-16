package com.example.trabajofinalv1.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Turno implements Serializable {

    @Id
    @GeneratedValue(generator = "secuenciaDeTurno" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secuenciaDeTurno", sequenceName = "BD_SECUENCIA_TURNO", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDate fechaTurno;
}
