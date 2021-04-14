package com.example.demo.services;

import java.math.BigDecimal;

public interface INominaDeSueldoService<RequestDTO, ResponseDTO>{
    ResponseDTO incrementarSalario(RequestDTO dto);
}
