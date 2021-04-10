package com.example.demo.dtos;

import com.example.demo.models.RegistroSalarioEmpleado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Validated
@Data
public class EmpleadoDTO {
    private Integer id;

    @NotNull(message = "Nombre es requerido")
    @Size(min = 3, message = "En Nombre debe tener un minimo de 3 caracteres")
    private String nombre;

    @NotNull(message = "Apellido es requerido")
    @Size(min = 3, message = "En Apellido debe tener un minimo de 3 caracteres")
    private String apellido;

    @NotNull(message = "El DNI es requerido")
    @Size(min = 8, message = "DNI debe de poseer 8 caracteres")
    private String dni;

    @NotNull(message = "La antiguedad es requerido")
    @Size(min = 1, max = 2, message = "DNI debe de poseer minimo 1 caracter y maximo 2 caracteres")
    private Integer antiguedad;

    @NotNull(message = "El salario actual es requerido")
    private BigDecimal salarioActual;

    @JsonIgnore
    private List<RegistroSalarioEmpleado> registrosSalariosEmpleados;

}
