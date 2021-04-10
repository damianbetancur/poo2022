package com.example.demo.services;

import java.math.BigDecimal;

public interface NominaDeSueldoService<RequestDTO, ResponseDTO>{
    ResponseDTO incrementarSalario(RequestDTO dto);
}
