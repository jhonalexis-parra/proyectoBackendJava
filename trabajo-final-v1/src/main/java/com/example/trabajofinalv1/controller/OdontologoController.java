package com.example.trabajofinalv1.controller;

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
public class OdontologoController {

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    OdontologoService service;

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> getAll(){
        logger.info("Se solicitá la lista de odontologos");
        try {
            logger.debug("Se listan los odontologos");
            return ResponseEntity.ok(service.buscarTodos());
        }catch (Exception e){
            logger.error("Error en el listado de odontologos");
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearOdontologo (@RequestBody OdontologoDto odontologo){
        logger.info("Se solicitá crear un odontologo nuevo");
        try {
            logger.debug("Se crea el odontologo " + odontologo.toString());
            return ResponseEntity.ok(service.guardar(odontologo));
        }catch (Exception e){
            logger.error("Error al crear el odontologo: " + odontologo.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo (@RequestBody OdontologoDto odontologo){
        logger.info("Se solicitá actualizar un odontologo");
        if (odontologo.getId() != null){
            logger.debug("Se actualiza " + odontologo.toString());
            return ResponseEntity.ok(service.actualizar(odontologo));
        }else{
            logger.error("Error al actualizar el odontologo: " + odontologo.toString());
            return ResponseEntity.badRequest().body(odontologo);
        }
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<OdontologoDto>> buscarPorNombre(@PathVariable String nombre){
        logger.info("Se solicita búsqueda odontologos por nombre");
        try {
            logger.debug("Se encontraron los odontologos con el nombre " + nombre);
            return ResponseEntity.ok(service.buscarPorNombreDto(nombre));
        }catch (Exception e){
            logger.error("Error al buscar el odontologo por el nombre: " + nombre);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> borrarOdontologo (@RequestBody OdontologoDto odontologo){
        logger.info("Se solicita eliminar un odontologo");
        try{
            logger.debug("Se eliminó el odontologo " + odontologo.toString());
            return ResponseEntity.ok(service.borrar(odontologo));
        }catch (Exception e){
            logger.error("Error al eliminar el odontologo: " + odontologo.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
