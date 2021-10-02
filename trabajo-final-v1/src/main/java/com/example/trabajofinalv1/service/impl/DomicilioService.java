package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.model.DomicilioDto;
import com.example.trabajofinalv1.persistence.entities.Domicilio;
import com.example.trabajofinalv1.persistence.repository.IDomicilioRepository;
import com.example.trabajofinalv1.service.IServiceDomicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Domicilio> buscarPorId(Long id) {
        Optional<Domicilio> domicilioOptional = repository.findById(id);
        //Domicilio domicilio = domicilioOptional.get();
        return domicilioOptional;
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

    @Override
    public String borrarPorId(Long id) {
        repository.deleteById(id);
        return "Se ha eliminado el domicilio con id " + id;
    }

}
