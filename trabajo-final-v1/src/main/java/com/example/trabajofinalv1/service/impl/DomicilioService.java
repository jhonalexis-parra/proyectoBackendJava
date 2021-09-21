package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.model.DomicilioDto;
import com.example.trabajofinalv1.persistence.entities.Domicilio;
import com.example.trabajofinalv1.persistence.repository.IDomicilioRepository;
import com.example.trabajofinalv1.service.IServiceDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService implements IServiceDomicilio {

    @Autowired
    IDomicilioRepository repository;

    @Override
    public DomicilioDto guardar(DomicilioDto domicilio) {
        domicilio.setId(repository.save(domicilio.toEntity()).getId());
        return domicilio;
    }

    @Override
    public List<DomicilioDto> buscarTodos() {
        List<DomicilioDto> domicilios = new ArrayList<>();

        for(Domicilio d: repository.findAll()){
            domicilios.add(new DomicilioDto(d));
        }
        return domicilios;
    }

    @Override
    public DomicilioDto actualizar (DomicilioDto d){
        repository.save(d.toEntity());
        return d;
    }

    @Override
    public String borrar(DomicilioDto d) {
        repository.delete(d.toEntity());
        return "Se ha eliminado " + d.toString();
    }

}
