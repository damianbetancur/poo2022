package com.example.demo.dto.response;

import com.example.demo.dto.EmpleadoDTO;
import com.example.demo.enums.TipoExperiencia;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class IncrementoSalarioEmpleadoResponseDTO {
    private EmpleadoDTO unEmpleado;
    private TipoExperiencia unTipoExperiencia;
}
