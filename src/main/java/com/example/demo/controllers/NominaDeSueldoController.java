package com.example.demo.controllers;


import com.example.demo.dtos.request.IncrementoSalarioEmpleadoRequestDTO;
import com.example.demo.dtos.response.IncrementoSalarioEmpleadoResponseDTO;
import com.example.demo.services.INominaDeSueldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/api/v1/nomina")
public class NominaDeSueldoController {

    private INominaDeSueldoService INominaDeSueldoService;

    public NominaDeSueldoController(INominaDeSueldoService INominaDeSueldoService) {
        this.INominaDeSueldoService = INominaDeSueldoService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<IncrementoSalarioEmpleadoResponseDTO> incrementarSalarioEmpleado(@Valid @RequestBody IncrementoSalarioEmpleadoRequestDTO incrementoSalarioEmpleadoRequestDTO)  {

        IncrementoSalarioEmpleadoResponseDTO nuevoIncrementoDeSalarioEmpleado = (IncrementoSalarioEmpleadoResponseDTO) INominaDeSueldoService.incrementarSalario(incrementoSalarioEmpleadoRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/empleado/{id}")
                .buildAndExpand(nuevoIncrementoDeSalarioEmpleado.getUnEmpleado().getId()).toUri();
        return new ResponseEntity<IncrementoSalarioEmpleadoResponseDTO>(nuevoIncrementoDeSalarioEmpleado, HttpStatus.CREATED).created(location).body(nuevoIncrementoDeSalarioEmpleado);
    }
}
