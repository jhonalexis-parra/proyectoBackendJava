package com.example.trabajofinalv1.controller;

import com.example.trabajofinalv1.model.PacienteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public interface CRUDcontroller <T> {

    @GetMapping("/buscarTodos")
    public ResponseEntity<?> buscarTodos();

    @GetMapping("buscarPorId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id);

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody T t);

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar (@RequestBody T t);

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrar (@RequestBody T t);

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarPorId (@PathVariable Long id);

}
