package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "registros_salarios_empleados")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistroSalarioEmpleado {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha")
    @NotNull(message = "La fecha no puede ser Nulo")
    private LocalDate fecha;

    @Column(name = "monto")
    @NotNull(message = "El monto no puede ser 0")
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "id_empleado_fk", nullable = false)
    private Empleado unEmpleado;

}
