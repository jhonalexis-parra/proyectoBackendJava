package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.repository.IOdontologoRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IService<Odontologo> {

    @Autowired
    IOdontologoRepository repository;


    @Override
    public String save(Odontologo odontologo) {
        if(repository.save(odontologo) != null){
            return "OK";
        }else{
            return null;
        }
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        return repository.findAll();
    }
}
