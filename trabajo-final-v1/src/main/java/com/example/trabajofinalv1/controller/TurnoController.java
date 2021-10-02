package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.model.TurnoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.entities.Turno;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import com.example.trabajofinalv1.service.impl.PacienteService;
import com.example.trabajofinalv1.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<?> registrarTurno(@RequestBody TurnoDto t){
        ResponseEntity<TurnoDto> response;
        if (pacienteService.buscarPorId(t.getPaciente().getId()).isPresent() && odontologoService.buscarPorId(t.getOdontologo().getId()).isPresent())
            response = ResponseEntity.ok(turnoService.guardar(t));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(turnoService.buscarTodos());
    }




}
