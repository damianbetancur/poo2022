package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
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
    private LocalDate fecha;

    @Column(name = "monto")
    private float monto;

    @ManyToOne
    @JoinColumn(name = "id_empleado_fk", nullable = false)
    private Empleado unEmpleado;
}
