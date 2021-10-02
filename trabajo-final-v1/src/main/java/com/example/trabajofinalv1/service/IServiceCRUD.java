package com.example.trabajofinalv1.service;



import java.util.List;
import java.util.Optional;

public interface IServiceCRUD<T> {
    T guardar(T t);
    List<T> buscarTodos();
    Optional<?> buscarPorId(Long id);
    T actualizar (T t);
    String borrar (T t);
    String borrarPorId (Long id);

}
