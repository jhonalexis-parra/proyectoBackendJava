package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.dto.PacienteDto;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.repository.IPacienteRepository;
import com.example.trabajofinalv1.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService  {

    @Autowired
    IPacienteRepository repository;


    public PacienteDto guardar(PacienteDto paciente) {
        paciente.setFechaIngreso(LocalDate.now());
        paciente.setId(repository.save(paciente.toEntity()).getId());
        return paciente;
    }

    public PacienteDto buscar(Long id){
        return new PacienteDto(repository.getById(id));
    }

    public List<PacienteDto> buscarTodos() {
        List<PacienteDto> pacientes = new ArrayList<>();

        for(Paciente p: repository.findAll()){
            pacientes.add(new PacienteDto(p));
        }
        return pacientes;
    }

    public PacienteDto actualizar (PacienteDto p){
        repository.save(p.toEntity());
        return p;
    }




}
