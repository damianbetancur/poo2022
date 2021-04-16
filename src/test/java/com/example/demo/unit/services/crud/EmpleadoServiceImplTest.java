package com.example.demo.unit.services.crud;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.dtos.EmpleadoDTO;
import com.example.demo.models.Empleado;
import com.example.demo.repositories.EmpleadoRepository;
import com.example.demo.services.crud.impl.EmpleadoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceImplTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    EmpleadoDTO empleadoDTO = new EmpleadoDTO();




    @Test
    public void registrar() {
        //when(empleadoRepository.save(any(Empleado.class))).thenReturn(null);
        //when(empleadoRepository.save(any(UserForm.class)))
        //assertTrue(loginService.login(userForm));
        //verify(loginRepository, atLeast(1)).login(userForm);

        //EmpleadoDTO emp = new EmpleadoDTO(1, "juan", "perez", "30677736", 1, new BigDecimal(10), null);

        //when(empleadoRepository.findByDni(anyString())).thenReturn(null);
        //EmpleadoDTO emp = new EmpleadoDTO(1, "juan", "perez", "30677736", 1, new BigDecimal(10), null);

        //when(empleadoRepository.findByDni(anyString())).thenReturn(null);


        //EmpleadoDTO empleadoGuardado = empleadoService.registrar(emp);


        //Assert.assertNotNull(empleadoGuardado);

    }

    @Test
    public void modificar() {
    }

    @Test
    public void eliminar() {
    }

    @Test
    public void listarId() {
    }

    @Test
    public void listarTodos() {


        //when(empleadoRepository.findAll()).thenReturn(new ArrayList<Empleado>() {{ add(new Empleado(1, "juan", "perez", "30677736", 1, new BigDecimal(10), null)); add(new Empleado(2, "juan", "perez", "30677736", 1, new BigDecimal(10), null)); add(new Empleado(3, "juan", "perez", "30677736", 1, new BigDecimal(10), null)); }});

        //empleadoService.listarTodos();

        //Assert.assertEquals(empleadoRepository.findAll().size(), empleadoService.listarTodos().size());
    }

    @Test
    public void buscarRegistrosSalariosEmpleadosPorEmpleado() {
    }
}