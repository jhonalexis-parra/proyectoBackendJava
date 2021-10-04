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

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita búsqueda de paciente por id");
        if (id < 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor o igual a cero");
        }
        logger.debug("Se encontro el paciente con el id " + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearPaciente (@RequestBody PacienteDto paciente) throws ResourceNotFoundException{
        logger.info("Se solicitá crear un paciente nuevo");
        if (paciente.getNombre().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene nombre, agregar el nombre");
        }
        else if (paciente.getApellido().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene apellido, agregar el apellido");
        }
        else if (paciente.getDni().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene DNI, agregar el DNI");
        }
        else if (paciente.getDomicilio().getCalle().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene en su domicilio la calle, agregar la calle");
        }
        else if (paciente.getDomicilio().getNumero().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene en su domicilio el número, agregar el número");
        }
        else if (paciente.getDomicilio().getLocalidad().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene en su domicilio la localidad, agregar la localidad");
        }
        else if (paciente.getDomicilio().getProvincia().equals(null)){
            throw new ResourceNotFoundException("El paciente no tiene en su domicilio la provincia, agregar la provincia");
        }
        logger.debug("Se crea el paciente " + paciente.toString());
        return ResponseEntity.ok(service.guardar(paciente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente (@RequestBody PacienteDto paciente) throws ResourceNotFoundException{
        logger.info("Se solicitá actualizar un paciente");
        if (paciente.getId() == null){
            throw new ResourceNotFoundException("Se debe enviar el id del paciente a actualizar, enviar id");
        }
        logger.debug("Se actualiza " + paciente.toString());
        return ResponseEntity.ok(service.actualizar(paciente));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> borrarPaciente (@RequestBody PacienteDto paciente) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar un paciente");
        if (paciente.getId() == null){
            throw new ResourceNotFoundException("Se debe enviar el id del paciente para ser eliminado");
        }
        logger.debug("Se eliminó el paciente " + paciente.toString());
        return ResponseEntity.ok(service.borrar(paciente));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> borrarPacientePorId (@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar el paciente con id " + id);
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor a cero");
        }
        logger.debug("Se elimino el paciente con el id " + id);
        return ResponseEntity.ok(service.borrarPorId(id));
    }
}
