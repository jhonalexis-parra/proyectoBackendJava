package com.example.trabajofinalv1.persistence.repository;

import com.example.trabajofinalv1.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
