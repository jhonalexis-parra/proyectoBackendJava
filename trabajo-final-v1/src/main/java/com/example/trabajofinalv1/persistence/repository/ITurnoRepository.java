package com.example.trabajofinalv1.persistence.repository;

import com.example.trabajofinalv1.persistence.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
