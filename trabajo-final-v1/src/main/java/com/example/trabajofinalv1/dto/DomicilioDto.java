package com.example.trabajofinalv1.dto;

import com.example.trabajofinalv1.persistence.entities.Domicilio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicilioDto {

    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public DomicilioDto() {
    }

    public DomicilioDto(Long id){
        this.id = id;
    }

    public DomicilioDto(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioDto(Long id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioDto (Domicilio d){
        id = d.getId();
        calle = d.getCalle();
        numero = d.getNumero();
        localidad = d.getLocalidad();
        provincia = d.getProvincia();
    }

    public Domicilio toEntity(){
        Domicilio entity = new Domicilio();

        entity.setId(id);
        entity.setCalle(calle);
        entity.setLocalidad(localidad);
        entity.setProvincia(provincia);
        entity.setNumero(numero);

        return entity;
    }

}
