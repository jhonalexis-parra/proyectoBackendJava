package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.persistence.entities.Domicilio;
import com.example.trabajofinalv1.persistence.repository.IDomicilioRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService implements IService<Domicilio> {

    @Autowired
    IDomicilioRepository repository;

    @Override
    public String save(Domicilio domicilio) {
        if(repository.save(domicilio) != null){
            return "OK";
        }else{
            return null;
        }
    }

    @Override
    public List<Domicilio> obtenerTodos() {
        return repository.findAll();
    }
}
