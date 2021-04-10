package com.example.demo.services.crud;

import com.example.demo.dtos.RegistroSalarioEmpleadoDTO;
import com.example.demo.models.Empleado;

import java.util.List;

public interface IRegistroSalarioEmpleadoService extends ICRUD<RegistroSalarioEmpleadoDTO>{
    List<RegistroSalarioEmpleadoDTO> buscarRegistrosSalariosEmpleadosPorEmpleado(Empleado unEmpleado);
}
