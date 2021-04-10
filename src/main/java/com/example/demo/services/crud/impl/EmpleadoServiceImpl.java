package com.example.demo.services.crud.impl;

import com.example.demo.dtos.EmpleadoDTO;
import com.example.demo.models.Empleado;
import com.example.demo.repositories.EmpleadoRepository;
import com.example.demo.services.crud.IEmpleadoService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    private EmpleadoRepository  empleadoRepository;

    private final ModelMapper modelMapper;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, ModelMapper modelMapper) {
        this.empleadoRepository = empleadoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public EmpleadoDTO registrar(EmpleadoDTO empleadoDTO) {
        Empleado nuevoEmpleado = modelMapper.map(empleadoDTO, Empleado.class);
        if (empleadoRepository.exists(Example.of(nuevoEmpleado))) {
            throw new DuplicateKeyException("Ya existe el Empleado con dni: " + nuevoEmpleado.getDni());
        }
        empleadoRepository.save(nuevoEmpleado);
        empleadoDTO.setId(nuevoEmpleado.getId());
        return empleadoDTO;
    }

    @Override
    @Transactional
    public EmpleadoDTO modificar(EmpleadoDTO empleadoDTO) {
        Empleado nuevoEmpleado = modelMapper.map(empleadoDTO, Empleado.class);
        empleadoRepository.save(nuevoEmpleado);
        return empleadoDTO;
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Empleado> opt = empleadoRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NoSuchElementException("No existe empleado con el id: " + id);
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoDTO listarId(Integer id) {
        Optional<Empleado> opt = empleadoRepository.findById(id);

        if (!opt.isPresent()) {
            throw new NoSuchElementException("No existe empleado con el id: " + id);
        }
        return modelMapper.map(opt.get(), EmpleadoDTO.class);
    }

    @Override
    public List<EmpleadoDTO> listarTodos() {
        List<EmpleadoDTO> empleadosDTO = empleadoRepository.findAll()
                .stream()
                .map(empleado -> modelMapper.map(empleado, EmpleadoDTO.class))
                .collect(Collectors.toList());
        return empleadosDTO;
    }

    @Override
    public EmpleadoDTO buscarEmpleadoPorDNI(String dni) {
        Optional<Empleado> opt = Optional.ofNullable(empleadoRepository.findByDni(dni));

        if (!opt.isPresent()) {
            throw new NoSuchElementException("No existe empleado con el dni: " + dni);
        }
        return modelMapper.map(opt.get(), EmpleadoDTO.class);
    }
}
