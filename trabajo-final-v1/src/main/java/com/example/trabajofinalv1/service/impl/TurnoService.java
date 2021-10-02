package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.model.TurnoDto;
import com.example.trabajofinalv1.persistence.repository.ITurnoRepository;
import com.example.trabajofinalv1.persistence.repository.IUserRepository;
import com.example.trabajofinalv1.service.IServiceTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements IServiceTurno {

    @Autowired
    ITurnoRepository repository;

    @Override
    public TurnoDto guardar(TurnoDto turnoDto) {
        return null;
    }

    @Override
    public List<TurnoDto> buscarTodos() {
        return null;
    }

    @Override
    public Optional<?> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public TurnoDto actualizar(TurnoDto turnoDto) {
        return null;
    }

    @Override
    public String borrar(TurnoDto turnoDto) {
        return null;
    }

    @Override
    public String borrarPorId(Long id) {
        return null;
    }
}
