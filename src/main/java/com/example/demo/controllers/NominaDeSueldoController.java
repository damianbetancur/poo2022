package com.example.demo.controllers;


import com.example.demo.dto.request.IncrementoSalarioEmpleadoRequestDTO;
import com.example.demo.dto.response.IncrementoSalarioEmpleadoResponseDTO;
import com.example.demo.services.INominaDeSueldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(NominaDeSueldoController.RESOURCE)
public class NominaDeSueldoController {

    public static final String RESOURCE = "/api/v1/nominas";

    private INominaDeSueldoService INominaDeSueldoService;

    public NominaDeSueldoController(INominaDeSueldoService INominaDeSueldoService) {
        this.INominaDeSueldoService = INominaDeSueldoService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<IncrementoSalarioEmpleadoResponseDTO> incrementarSalarioEmpleado(@Validated @RequestBody IncrementoSalarioEmpleadoRequestDTO incrementoSalarioEmpleadoRequestDTO)  {

        IncrementoSalarioEmpleadoResponseDTO nuevoIncrementoDeSalarioEmpleado = (IncrementoSalarioEmpleadoResponseDTO) INominaDeSueldoService.incrementarSalario(incrementoSalarioEmpleadoRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(nuevoIncrementoDeSalarioEmpleado.getUnEmpleado().getId()).toUri();
        return new ResponseEntity<IncrementoSalarioEmpleadoResponseDTO>(nuevoIncrementoDeSalarioEmpleado, HttpStatus.CREATED).created(location).body(nuevoIncrementoDeSalarioEmpleado);
    }

}
