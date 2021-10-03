package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    PacienteService service;

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDto>> getAll() throws ResourceNotFoundException {
        logger.info("Se solicitá la lista de pacientes");
        logger.debug("Se listan los pacientes");
        return ResponseEntity.ok(service.buscarTodos());

    }

    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearPaciente (@RequestBody PacienteDto paciente) throws ResourceNotFoundException{
        logger.info("Se solicitá crear un paciente nuevo");
        try{
            logger.debug("Se crea el paciente " + paciente.toString());
            return ResponseEntity.ok(service.guardar(paciente));
        }catch (Exception e){
            logger.error("Error al crear el paciente: " + paciente.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente (@RequestBody PacienteDto paciente) throws ResourceNotFoundException{
        logger.info("Se solicitá actualizar un paciente");
        if (paciente.getId() != null){
            logger.debug("Se actualiza " + paciente.toString());

            return ResponseEntity.ok(service.actualizar(paciente));
        }else{
            logger.error("Error al actualizar el paciente: " + paciente.toString());
            return ResponseEntity.badRequest().body(paciente);
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> borrarPaciente (@RequestBody PacienteDto paciente){
        logger.info("Se solicita eliminar un paciente");
        try {
            logger.debug("Se eliminó el odontologo " + paciente.toString());
            return ResponseEntity.ok(service.borrar(paciente));
        } catch (Exception e){
            logger.error("Error al eliminar el odontologo: " + paciente.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> borrarPacientePorId (@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar un paciente con id " + id);
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor a cero");
        }
        logger.debug("Se elimino el odontologo con el id " + id);
        return ResponseEntity.ok(service.borrarPorId(id));
    }
}
