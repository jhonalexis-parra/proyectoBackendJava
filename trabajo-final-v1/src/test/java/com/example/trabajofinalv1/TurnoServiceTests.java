package com.example.trabajofinalv1;


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

    public void cargarDataSet() {
        DomicilioDto domicilio = new DomicilioDto("Av Santa fe", "444", "CABA", "Buenos Aires");
        PacienteDto p = pacienteService.guardar(new PacienteDto("Santiago", "Paz", "88888888", new Date(), domicilio));
        this.odontologoService.guardar(new OdontologoDto("Santiago", "Paz", "3455647"));
    }
    @Test
    public void altaTurnoTest(){
        this.cargarDataSet();
        turnoService.guardar(new TurnoDto(new OdontologoDto(odontologoService.buscarPorId(1L).get()), new PacienteDto(pacienteService.buscarPorId(1L).get()),new Date()));
        Assert.assertNotNull(turnoService.buscarPorId(1L));
    }
    @Test
    public void buscarTurnoTest(){
        Assert.assertNotNull(turnoService.buscarPorId(1L));
    }
    @Test
    public void eliminarTurnoTest(){
        turnoService.borrarPorId(1L);
        Assert.assertFalse(turnoService.buscarPorId(1L).isPresent());
    }

}
