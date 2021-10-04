package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.exceptions.GlobalExceptions;
import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;
import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController{

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    OdontologoService service;

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> getAll() throws ResourceNotFoundException {
        logger.info("Se solicitá la lista de odontólogos");
        logger.info("Se listan los odontólogos");
        return ResponseEntity.ok(service.buscarTodos());
   }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearOdontologo (@RequestBody OdontologoDto odontologo) throws ResourceNotFoundException {
        logger.info("Se solicitá crear un odontologo nuevo");
        if (odontologo.getNombre().equals(null)){
            throw new ResourceNotFoundException("Falta agregar el nombre del odontólogo");
        }
        else if(odontologo.getApellido().equals(null) ){
            throw new ResourceNotFoundException("Falta agregar el apellido del odontólogo");
        }
        else if(odontologo.getMatricula().equals(null)){
            throw new ResourceNotFoundException("Falta agregar la matricula del odontólogo");
        }
        logger.info("Se crea un odontólogo nuevo");
        return ResponseEntity.ok(service.guardar(odontologo));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo (@RequestBody OdontologoDto odontologo) throws ResourceNotFoundException{
        logger.info("Se solicitá actualizar un odontólogo");
        if (odontologo.getId() == null){
            throw new ResourceNotFoundException("Falta agregar el id del odontólogo");
        }
        logger.debug("Se actualiza " + odontologo.toString());
        return ResponseEntity.ok(service.actualizar(odontologo));
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<OdontologoDto>> buscarPorNombre(@PathVariable String nombre) throws ResourceNotFoundException{
        logger.info("Se solicita búsqueda odontologos por nombre");
        if (nombre.equals("")){
            throw new ResourceNotFoundException("No es posible enviar un nombre vacio, envie un nombre completo");
        }
        logger.debug("Se encontraron los odontologos con el nombre " + nombre);
        return ResponseEntity.ok(service.buscarPorNombreDto(nombre));
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita búsqueda del odontologo con el id");
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor o igual a cero");
        }
        logger.debug("Se encontró el odontólogo con el id " + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> borrarOdontologo (@RequestBody OdontologoDto odontologo) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar un odontologo");
        if (odontologo.getId() == null){
            throw new ResourceNotFoundException("Se debe enviar el id del odontologo para ser eliminado");
        }
        logger.debug("Se eliminó el odontologo " + odontologo.toString());
        return ResponseEntity.ok(service.borrar(odontologo));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> borrarPorId(@PathVariable Long id) throws ResourceNotFoundException{
        logger.info("Se solicita eliminar odontólogo por id");
        if (id <= 0){
            throw new ResourceNotFoundException("No es posible enviar un id negativo, envie un id entero mayor a cero");
        }
        logger.debug("Se elimino el odontólogo con el id " + id);
        return ResponseEntity.ok(service.borrarPorId(id));
    }
}
