package com.example.trabajofinalv1.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Turno implements Serializable {

    @Id
    @GeneratedValue(generator = "secuenciaDeTurno" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "secuenciaDeTurno", sequenceName = "BD_SECUENCIA_TURNO", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private Date fechaTurno;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, Date fechaTurno) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaTurno = fechaTurno;
    }
}
