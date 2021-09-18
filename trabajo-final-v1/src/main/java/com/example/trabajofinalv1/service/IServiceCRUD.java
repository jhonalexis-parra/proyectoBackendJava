package com.example.trabajofinalv1.service;

import java.util.List;

public interface IServiceCRUD<T> {
    T guardar(T t);
    List<T> buscarTodos();
    T actualizar (T t);

}
