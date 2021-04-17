package com.example.demo.repositories;

import com.example.demo.models.Empleado;
import com.example.demo.models.RegistroSalarioEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroSalarioEmpleadoRepository extends JpaRepository<RegistroSalarioEmpleado, Integer> {

    List<RegistroSalarioEmpleado> findByUnEmpleado(Empleado empleado);

}
