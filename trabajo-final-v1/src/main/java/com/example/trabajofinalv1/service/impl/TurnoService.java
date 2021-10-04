package com.example.trabajofinalv1.service.impl;

import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;
import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.model.TurnoDto;
import com.example.trabajofinalv1.persistence.entities.Turno;
import com.example.trabajofinalv1.persistence.repository.ITurnoRepository;

import com.example.trabajofinalv1.service.IServiceTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoService implements IServiceTurno {

    @Autowired
    ITurnoRepository repository;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    @Override
    public TurnoDto guardar(TurnoDto turnoDto) throws ResourceNotFoundException {

        PacienteDto paciente = new PacienteDto(pacienteService.buscarPorId(turnoDto.getPaciente().getId()).get());
        OdontologoDto odontologo = new OdontologoDto(odontologoService.buscarPorId(turnoDto.getOdontologo().getId()).get());
        turnoDto.setPaciente(paciente);
        turnoDto.setOdontologo(odontologo);

        for (Turno t: repository.findAll()){
            System.out.println("Entre al repositorio");
            if (t.getOdontologo().getId() == turnoDto.getOdontologo().getId() && (t.getFechaTurno().compareTo(turnoDto.getFechaTurno()) == 0)){
                System.out.println("El odontologo ya tiene turno en este horario, agendar otro horario");
            }
            if (t.getPaciente().getId() == turnoDto.getPaciente().getId() && (t.getFechaTurno().compareTo(turnoDto.getFechaTurno()) == 0)){
                System.out.println("Los pacientes son iguales");
                throw new ResourceNotFoundException("El paciente ya tiene turno en este horario, agendar otro horario");
            }

        }

        repository.save(turnoDto.toEntity());

        return turnoDto;
    }

    @Override
    public List<TurnoDto> buscarTodos() {
        List <TurnoDto> turnos = repository.findAll().stream().map(o -> new TurnoDto(o)).collect(Collectors.toList());
        return turnos;
    }

    @Override
    public Optional<?> buscarPorId(Long id) {
        Optional<Turno> turnoOptional = repository.findById(id);
        return turnoOptional;
    }

    @Override
    public TurnoDto actualizar(TurnoDto turnoDto) throws ResourceNotFoundException {
        PacienteDto paciente = new PacienteDto(pacienteService.buscarPorId(turnoDto.getPaciente().getId()).get());
        OdontologoDto odontologo = new OdontologoDto(odontologoService.buscarPorId(turnoDto.getOdontologo().getId()).get());
        turnoDto.setPaciente(paciente);
        turnoDto.setOdontologo(odontologo);

        for (Turno t: repository.findAll()){
            System.out.println("Entre al repositorio");
            if (t.getOdontologo().getId() == turnoDto.getOdontologo().getId() && (t.getFechaTurno().compareTo(turnoDto.getFechaTurno()) == 0)){
                System.out.println("El odontologo ya tiene turno en este horario, agendar otro horario");
            }
            if (t.getPaciente().getId() == turnoDto.getPaciente().getId() && (t.getFechaTurno().compareTo(turnoDto.getFechaTurno()) == 0)){
                System.out.println("Los pacientes son iguales");
                throw new ResourceNotFoundException("El paciente ya tiene turno en este horario, agendar otro horario");
            }

        }

        repository.save(turnoDto.toEntity());

        return turnoDto;
    }

    @Override
    public String borrar(TurnoDto turnoDto) {
        repository.delete(turnoDto.toEntity());
        return "Se ha eliminado " + turnoDto.toString();
    }

    @Override
    public String borrarPorId(Long id) {
        repository.deleteById(id);
        return "Se ha eliminado el turno con el id " + id;
    }

    public List<TurnoDto> buscarProximosSieteDias (){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Timestamp.valueOf(LocalDateTime.now()));
        System.out.println(calendar);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        System.out.println(calendar);
        List <TurnoDto> turnos = new ArrayList<>();
        //List <TurnoDto> turnos = (List<TurnoDto>) repository.findAll().stream().filter(turnoDto -> turnoDto.getFechaTurno().before(calendar.getTime()));
        for (Turno t: repository.findAll()) {
            if (t.getFechaTurno().before(calendar.getTime())){
                turnos.add(new TurnoDto(t));
            }

        }

        return turnos;

    }


}
