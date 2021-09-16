package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.dto.OdontologoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.repository.IOdontologoRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService {

    @Autowired
    IOdontologoRepository repository;


    public OdontologoDto guardar (OdontologoDto odontologo){
        odontologo.setId(repository.save(odontologo.toEntity()).getId());
        return odontologo;
    }

    public OdontologoDto buscar (Long id){
        return new OdontologoDto(repository.getById(id));
    }

    public List<OdontologoDto> buscarTodos(){
        //List <OdontologoDto> odontologos = new ArrayList<>();

        List <OdontologoDto> odontologos = repository.findAll().stream().map(o -> new OdontologoDto(o)).collect(Collectors.toList());

        //for (Odontologo o: repository.findAll()){
        //   odontologos.add(new OdontologoDto(o));
        //}
        return odontologos;
    }

    public OdontologoDto actualizar (OdontologoDto o){
        repository.save(o.toEntity());
        return o;
    }

}
