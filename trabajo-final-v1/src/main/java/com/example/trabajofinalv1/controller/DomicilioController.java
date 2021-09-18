package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.model.DomicilioDto;
import com.example.trabajofinalv1.service.impl.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @GetMapping("/todos")
    public ResponseEntity<List<DomicilioDto>> getAll(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<DomicilioDto> crearDomicilio (@RequestBody DomicilioDto domicilio){
        return ResponseEntity.ok(service.guardar(domicilio));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DomicilioDto> actualizarDomicilio (@RequestBody DomicilioDto domicilio){
        if (domicilio.getId() != null){
            return ResponseEntity.ok(service.actualizar(domicilio));
        }else{
            return ResponseEntity.badRequest().body(domicilio);
        }
    }


}
