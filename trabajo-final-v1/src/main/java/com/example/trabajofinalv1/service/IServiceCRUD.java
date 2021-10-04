package com.example.trabajofinalv1.service;



import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IServiceCRUD<T> {
    T guardar(T t) throws ResourceNotFoundException;
    List<T> buscarTodos();
    Optional<?> buscarPorId(Long id);
    T actualizar (T t) throws ResourceNotFoundException;
    String borrar (T t);
    String borrarPorId (Long id);

}
