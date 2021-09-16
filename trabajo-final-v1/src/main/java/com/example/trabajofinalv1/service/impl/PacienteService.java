package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.repository.IPacienteRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteService implements IService<Paciente> {

    @Autowired
    IPacienteRepository repository;

    @Override
    public String save(Paciente paciente) {
        paciente.setFechaIngreso(LocalDate.now());
        if(repository.save(paciente) != null){
            return "OK";
        }else{
            return null;
        }
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return repository.findAll();
    }
}
