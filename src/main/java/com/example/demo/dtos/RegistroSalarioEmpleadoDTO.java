package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RegistroSalarioEmpleadoDTO {

    @Nullable
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private BigDecimal monto;

    private EmpleadoDTO unEmpleado;
}
