package com.example.trabajofinalv1.dto;

import com.example.trabajofinalv1.persistence.entities.Odontologo;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OdontologoDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    public OdontologoDto() {
    }

    public OdontologoDto(Long id){
        this.id = id;
    }

    public OdontologoDto(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public OdontologoDto(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public OdontologoDto (Odontologo o){
        id = o.getId();
        nombre = o.getNombre();
        apellido = o.getApellido();
        matricula = o.getMatricula();
    }

    public Odontologo toEntity (){
        Odontologo entity = new Odontologo();

        entity.setId(id);
        entity.setNombre(nombre);
        entity.setApellido(apellido);
        entity.setMatricula(matricula);

        return  entity;
    }

}
