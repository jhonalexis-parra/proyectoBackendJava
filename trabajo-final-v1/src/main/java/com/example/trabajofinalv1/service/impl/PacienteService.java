package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.repository.IPacienteRepository;
import com.example.trabajofinalv1.service.IServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService  implements IServicePaciente {

    @Autowired
    IPacienteRepository repository;

    @Override
    public PacienteDto guardar(PacienteDto paciente) {
        paciente.setFechaIngreso(LocalDate.now());
        paciente.setId(repository.save(paciente.toEntity()).getId());
        return paciente;
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        List<PacienteDto> pacientes = new ArrayList<>();

        for(Paciente p: repository.findAll()){
            pacientes.add(new PacienteDto(p));
        }
        return pacientes;
    }

    @Override
    public PacienteDto actualizar (PacienteDto p){
        PacienteDto pacienteAntiguo = new PacienteDto(repository.getById(p.getId()));
        p.getDomicilio().setId(pacienteAntiguo.getDomicilio().getId());
        p.setFechaIngreso(repository.getById(p.getId()).getFechaIngreso());
        repository.save(p.toEntity());
        return p;
    }

    @Override
    public String borrar(PacienteDto p) {
        repository.delete(p.toEntity());
        return "Se ha eliminado " + p.toString();
    }




}
