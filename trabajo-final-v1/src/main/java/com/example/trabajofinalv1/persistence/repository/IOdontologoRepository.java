package com.example.trabajofinalv1.persistence.repository;

import com.example.trabajofinalv1.persistence.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("FROM Odontologo u WHERE u.nombre = ?1")
    List<Odontologo> buscarOdontologoPorNombre(String nombre);
}
