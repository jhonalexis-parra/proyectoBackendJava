package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.repository.IPacienteRepository;
import com.example.trabajofinalv1.service.IServicePaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService  implements IServicePaciente {

    @Autowired
    IPacienteRepository repository;

    @Override
    public PacienteDto guardar(PacienteDto paciente) {
        paciente.setFechaIngreso(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
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
    public Optional<Paciente> buscarPorId(Long id) {
        Optional<Paciente> pacienteOptional = repository.findById(id);
        //Paciente paciente = pacienteOptional.get();
        return pacienteOptional;
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

    @Override
    public String borrarPorId(Long id) {
        repository.deleteById(id);
        return "Se ha eliminado el paciente con el id " + id;
    }


}
