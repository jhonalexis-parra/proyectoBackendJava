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
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(generator = "secuenciaDeDomicilio", strategy =  GenerationType.SEQUENCE)
    @SequenceGenerator(name ="secuenciaDeDomicilio", sequenceName = "BD_SECUENCIA_DOMICILIO", allocationSize = 1)
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domicilio")
    private Set<Paciente> pacientes;

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {
    }
}
