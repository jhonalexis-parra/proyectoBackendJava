package com.example.trabajofinalv1;


import com.example.trabajofinalv1.exceptions.ResourceNotFoundException;
import com.example.trabajofinalv1.model.DomicilioDto;
import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.model.TurnoDto;
import com.example.trabajofinalv1.persistence.entities.Domicilio;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import com.example.trabajofinalv1.service.impl.PacienteService;
import com.example.trabajofinalv1.service.impl.TurnoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;


    @Test
    public void altaTurnoTest() throws ResourceNotFoundException {
        //Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 80", "30", "Barrios Unidos", "Bogotá");
        PacienteDto p = pacienteService.guardar(new PacienteDto("Jhon", "Parra", "834388888", new Date(), domicilio));
        odontologoService.guardar(new OdontologoDto("Valentina", "Arbelaez", "C0001"));
        //Cuando
        turnoService.guardar(new TurnoDto(new OdontologoDto(odontologoService.buscarPorId(1L).get()), new PacienteDto(pacienteService.buscarPorId(1L).get()),new Date()));
        //Entonces
        Assert.assertNotNull(turnoService.buscarPorId(1L));
    }

    @Test
    public void buscarTurnoTest(){
        //Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 190", "20", "Usaquen", "Bogotá");
        PacienteDto p = pacienteService.guardar(new PacienteDto("Paula", "Acuña", "69388888", new Date(), domicilio));
        odontologoService.guardar(new OdontologoDto("Daniel", "Blanco", "C0002"));
        //Cuando
        Optional<?> turno = turnoService.buscarPorId(1L);
        //Entonces
        Assert.assertNotNull(turno);
    }
    @Test
    public void eliminarTurnoTest(){
        //Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 13", "9", "Candelaria", "Bogotá");
        PacienteDto p = pacienteService.guardar(new PacienteDto("Carolina", "Duarte", "8898608888", new Date(), domicilio));
        odontologoService.guardar(new OdontologoDto("Jose", "Perez", "C0003"));
        //Cuando
        turnoService.borrarPorId(1L);
        //Entonce
        Assert.assertFalse(turnoService.buscarPorId(1L).isPresent());
    }

}
