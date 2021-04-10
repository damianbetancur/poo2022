package com.example.demo.services.crud;

import com.example.demo.dtos.EmpleadoDTO;

public interface IEmpleadoService extends ICRUD<EmpleadoDTO>{
    EmpleadoDTO buscarEmpleadoPorDNI(String dni);
}
