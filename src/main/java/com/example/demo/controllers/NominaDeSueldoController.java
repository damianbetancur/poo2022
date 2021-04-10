package com.example.demo.controllers;


import com.example.demo.dtos.request.IncrementoSalarioEmpleadoRequestDTO;
import com.example.demo.dtos.response.IncrementoSalarioEmpleadoResponseDTO;
import com.example.demo.services.NominaDeSueldoService;
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

    private NominaDeSueldoService nominaDeSueldoService;

    public NominaDeSueldoController(NominaDeSueldoService nominaDeSueldoService) {
        this.nominaDeSueldoService = nominaDeSueldoService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<IncrementoSalarioEmpleadoResponseDTO> incrementarSalarioEmpleado(@Valid @RequestBody IncrementoSalarioEmpleadoRequestDTO incrementoSalarioEmpleadoRequestDTO)  {

        IncrementoSalarioEmpleadoResponseDTO nuevoIncrementoDeSalarioEmpleado = (IncrementoSalarioEmpleadoResponseDTO) nominaDeSueldoService.incrementarSalario(incrementoSalarioEmpleadoRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/empleado/{id}")
                .buildAndExpand(nuevoIncrementoDeSalarioEmpleado.getUnEmpleado().getId()).toUri();
        return new ResponseEntity<IncrementoSalarioEmpleadoResponseDTO>(nuevoIncrementoDeSalarioEmpleado, HttpStatus.CREATED).created(location).body(nuevoIncrementoDeSalarioEmpleado);
    }
}
