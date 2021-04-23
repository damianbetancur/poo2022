package com.example.demo.unit.services.crud;


import com.example.demo.repositories.EmpleadoRepository;
import com.example.demo.services.crud.impl.EmpleadoServiceImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;


public class EmpleadoServiceImplTest {

    @Mock
    EmpleadoRepository empleadoRepository;


    @Autowired
    EmpleadoServiceImpl empleadoService;


    @Test
    public void registrar() throws Exception{


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
    }

    @Test
    public void buscarEmpleadoPorDNI() {
    }
}