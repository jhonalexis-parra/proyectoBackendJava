package com.example.trabajofinalv1.service;

import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;

import java.util.List;

public interface IServiceOdontologo extends IServiceCRUD<OdontologoDto>{

    List<OdontologoDto> buscarPorNombreDto (String nombre);

}
