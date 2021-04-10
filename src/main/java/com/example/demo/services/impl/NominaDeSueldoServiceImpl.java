package com.example.demo.services.impl;

import com.example.demo.dtos.EmpleadoDTO;
import com.example.demo.dtos.RegistroSalarioEmpleadoDTO;
import com.example.demo.dtos.request.IncrementoSalarioEmpleadoRequestDTO;
import com.example.demo.dtos.response.IncrementoSalarioEmpleadoResponseDTO;
import com.example.demo.enums.TipoExperiencia;
import com.example.demo.repositories.RegistroSalarioEmpleadoRepository;
import com.example.demo.services.NominaDeSueldoService;
import com.example.demo.services.crud.IEmpleadoService;
import com.example.demo.services.crud.IRegistroSalarioEmpleadoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class NominaDeSueldoServiceImpl implements NominaDeSueldoService<IncrementoSalarioEmpleadoRequestDTO, IncrementoSalarioEmpleadoResponseDTO> {

    private IEmpleadoService empleadoService;
    private IRegistroSalarioEmpleadoService registroSalarioEmpleadoService;

    private final ModelMapper modelMapper;


    public NominaDeSueldoServiceImpl(IEmpleadoService empleadoService, IRegistroSalarioEmpleadoService registroSalarioEmpleadoService, ModelMapper modelMapper) {
        this.empleadoService = empleadoService;
        this.registroSalarioEmpleadoService = registroSalarioEmpleadoService;
        this.modelMapper = modelMapper;
    }


    @Override
    public IncrementoSalarioEmpleadoResponseDTO incrementarSalario(IncrementoSalarioEmpleadoRequestDTO incrementoSalarioEmpleadoRequestDTO) {
        EmpleadoDTO empleado = this.empleadoService.buscarEmpleadoPorDNI(incrementoSalarioEmpleadoRequestDTO.getDni());
        RegistroSalarioEmpleadoDTO registroSalarioEmpleadoDTO = new RegistroSalarioEmpleadoDTO();

        IncrementoSalarioEmpleadoResponseDTO incrementoSalarioEmpleadoResponseDTO = new IncrementoSalarioEmpleadoResponseDTO();

        if (empleado!=null) {
            //  solo los empleados con más de 5 años de experiencia pueden obtener un aumento
            if (empleado.getAntiguedad() > 5) {
                empleado.setSalarioActual(empleado.getSalarioActual().add(incrementoSalarioEmpleadoRequestDTO.getMonto()));

                registroSalarioEmpleadoDTO.setUnEmpleado(this.empleadoService.registrar(empleado));

                registroSalarioEmpleadoDTO.setFecha(incrementoSalarioEmpleadoRequestDTO.getFecha());

                registroSalarioEmpleadoDTO.setMonto(incrementoSalarioEmpleadoRequestDTO.getMonto());

                registroSalarioEmpleadoService.registrar(registroSalarioEmpleadoDTO);

                incrementoSalarioEmpleadoResponseDTO.setUnTipoExperiencia(TipoExperiencia.CON_EXPERIENCIA);
            } else {
                incrementoSalarioEmpleadoResponseDTO.setUnTipoExperiencia(TipoExperiencia.SIN_EXPERIENCIA);
            }

            incrementoSalarioEmpleadoResponseDTO.setUnEmpleado(modelMapper.map(empleado, EmpleadoDTO.class));
        }
        return incrementoSalarioEmpleadoResponseDTO;
    }
}
