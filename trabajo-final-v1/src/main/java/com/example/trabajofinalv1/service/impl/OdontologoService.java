package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.controller.PacienteController;
import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.repository.IOdontologoRepository;
import com.example.trabajofinalv1.service.IServiceOdontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IServiceOdontologo {


    @Autowired
    IOdontologoRepository repository;

    @Override
    public OdontologoDto guardar (OdontologoDto odontologo){
        odontologo.setId(repository.save(odontologo.toEntity()).getId());
        return odontologo;
    }

    //public OdontologoDto buscar (Long id){
    //    return new OdontologoDto(repository.getById(id));
    //}

    @Override
    public List<OdontologoDto> buscarTodos(){
        //List <OdontologoDto> odontologos = new ArrayList<>();

        List <OdontologoDto> odontologos = repository.findAll().stream().map(o -> new OdontologoDto(o)).collect(Collectors.toList());

        //for (Odontologo o: repository.findAll()){
        //   odontologos.add(new OdontologoDto(o));
        //}
        return odontologos;
    }

    @Override
    public OdontologoDto actualizar (OdontologoDto o){
        // TODO realizar validación de datos de actualización del odontologo
        repository.save(o.toEntity());
        return o;
    }

    @Override
    public String borrar(OdontologoDto o) {
        repository.delete(o.toEntity());
        return "Se ha eliminado " + o.toString();
    }

    @Override
    public List<OdontologoDto> buscarPorNombreDto(String nombre) {
        List<OdontologoDto> odontologos = repository.buscarOdontologoPorNombre(nombre).stream().map(o -> new OdontologoDto(o)).collect(Collectors.toList());
        return odontologos;
    }


}
