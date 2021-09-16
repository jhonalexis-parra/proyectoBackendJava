package com.example.trabajofinalv1.service;

import java.util.List;

public interface IService<T> {
    String save(T t);
    List<T> obtenerTodos();
}
