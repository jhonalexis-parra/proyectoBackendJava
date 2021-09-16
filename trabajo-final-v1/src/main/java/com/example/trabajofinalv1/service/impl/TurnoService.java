package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.persistence.entities.Turno;
import com.example.trabajofinalv1.persistence.repository.ITurnoRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements IService<Turno> {

    @Autowired
    ITurnoRepository repository;

    @Override
    public String save(Turno turno) {
        if(repository.save(turno) != null){
            return "OK";
        }else{
            return null;
        }
    }

    @Override
    public List<Turno> obtenerTodos() {
        return repository.findAll();
    }
}
