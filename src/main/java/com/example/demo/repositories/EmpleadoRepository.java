package com.example.demo.repositories;

import com.example.demo.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByDni(String dni);
}
