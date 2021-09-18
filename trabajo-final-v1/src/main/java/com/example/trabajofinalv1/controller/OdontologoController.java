package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService service;

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> getAll(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearOdontologo (@RequestBody OdontologoDto odontologo){
        return ResponseEntity.ok(service.guardar(odontologo));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizarOdontologo (@RequestBody OdontologoDto odontologo){
        if (odontologo.getId() != null){
            return ResponseEntity.ok(service.actualizar(odontologo));
        }else{
            return ResponseEntity.badRequest().body(odontologo);
        }
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<List<OdontologoDto>> buscarPorNombre(@PathVariable String nombre){
        return ResponseEntity.ok(service.buscarPorNombreDto(nombre));
    }


}
