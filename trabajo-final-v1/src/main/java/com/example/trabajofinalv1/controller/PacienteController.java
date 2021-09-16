package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.dto.PacienteDto;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDto>> getAll(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearPaciente (@RequestBody PacienteDto paciente){
        return ResponseEntity.ok(service.guardar(paciente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente (@RequestBody PacienteDto paciente){
        if (paciente.getId() != null){
            return ResponseEntity.ok(service.actualizar(paciente));
        }else{
            return ResponseEntity.badRequest().body(paciente);
        }
    }

    // TODO agregar borrar y agregar buscar por id



}
