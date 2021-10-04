package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;
import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.model.TurnoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.entities.Turno;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import com.example.trabajofinalv1.service.impl.PacienteService;
import com.example.trabajofinalv1.service.impl.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;


    @PostMapping("/nuevo")
    public ResponseEntity<?> registrarTurno(@RequestBody TurnoDto t) throws ResourceNotFoundException {
        logger.info("Se solicitá crear un turno nuevo");
        ResponseEntity<TurnoDto> response;
        if (pacienteService.buscarPorId(t.getPaciente().getId()).isPresent() && odontologoService.buscarPorId(t.getOdontologo().getId()).isPresent())

            try {
                response = ResponseEntity.ok(turnoService.guardar(t));
            }catch (ResourceNotFoundException exception){
                throw new ResourceNotFoundException(exception.getMessage());
            }


        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        logger.info("Se crea un turno nuevo");
        return response;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<?> listar() {
        logger.info("Se solicitá la lista de turnos");
        logger.info("Se listan los turnos");
        return ResponseEntity.ok(turnoService.buscarTodos());
    }


    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDto> actualizarOdontologo (@RequestBody TurnoDto turno) throws ResourceNotFoundException{
        logger.info("Se solicitá actualizar un turno");
        if (turno.getId() == null){
            throw new ResourceNotFoundException("Falta agregar el id del turno");
        }
        logger.debug("Se actualiza " + turno.toString());
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }


    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita búsqueda del turno con el id");
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor o igual a cero");
        }
        logger.debug("Se encontró el turno con el id " + id);
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> borrar (@RequestBody TurnoDto turno) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar un turno");
        if (turno.getId() == null){
            throw new ResourceNotFoundException("Se debe enviar el id del turno para ser eliminado");
        }
        logger.debug("Se eliminó el odontologo " + turno.toString());
        return ResponseEntity.ok(turnoService.borrar(turno));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> borrarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar turno por id");
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor a cero");
        }
        logger.debug("Se elimino el turno con el id " + id);
        return ResponseEntity.ok(turnoService.borrarPorId(id));
    }

    @GetMapping("/listarProximoSieteDias")
    public ResponseEntity<?> listarlistarProximoSieteDias() {
        logger.info("Se solicitá la lista de turnos");
        logger.info("Se listan los turnos");
        return ResponseEntity.ok(turnoService.buscarProximosSieteDias());
    }






}
