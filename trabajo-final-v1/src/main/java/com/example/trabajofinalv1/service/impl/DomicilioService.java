package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.dto.DomicilioDto;
import com.example.trabajofinalv1.dto.PacienteDto;
import com.example.trabajofinalv1.persistence.entities.Domicilio;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.repository.IDomicilioRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService {

    @Autowired
    IDomicilioRepository repository;

    public DomicilioDto guardar(DomicilioDto domicilio) {
        domicilio.setId(repository.save(domicilio.toEntity()).getId());
        return domicilio;
    }

    public DomicilioDto buscar(Long id){
        return new DomicilioDto(repository.getById(id));
    }

    public List<DomicilioDto> buscarTodos() {
        List<DomicilioDto> domicilios = new ArrayList<>();

        for(Domicilio d: repository.findAll()){
            domicilios.add(new DomicilioDto(d));
        }
        return domicilios;
    }

    public DomicilioDto actualizar (DomicilioDto d){
        repository.save(d.toEntity());
        return d;
    }




    public String save(Domicilio domicilio) {
        if(repository.save(domicilio) != null){
            return "OK";
        }else{
            return null;
        }
    }


    public List<Domicilio> obtenerTodos() {
        return repository.findAll();
    }
}
