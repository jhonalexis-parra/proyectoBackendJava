package com.example.trabajofinalv1;

import com.example.trabajofinalv1.model.DomicilioDto;
import com.example.trabajofinalv1.model.PacienteDto;
import com.example.trabajofinalv1.service.impl.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTests {

    @Autowired
    private PacienteService pacienteService;

    public void cargarDataSet() {
        DomicilioDto domicilio = new DomicilioDto("Av Santa fe", "444", "CABA", "Buenos Aires");
        PacienteDto p = pacienteService.guardar(new PacienteDto("Santiago", "Paz", "88888888", new Date(), domicilio));
        DomicilioDto domicilio1 = new DomicilioDto("Av Avellaneda", "333", "CABA", "Buenos Aires");
        PacienteDto p1 = pacienteService.guardar(new PacienteDto("Micaela", "Perez", "99999999", new Date(), domicilio1));

    }

    @Test
    public void agregarPacienteTest() {
        //Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 80", "70", "Engativa", "Bogotá");
        // Cuando
        PacienteDto paciente = pacienteService.guardar(new PacienteDto("Jhon", "Parra", "545215122", new Date(), domicilio));
        // Entonces
        Assert.assertNotNull(pacienteService.buscarPorId(paciente.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        //Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 120", "70", "Suba", "Bogotá");
        PacienteDto paciente = pacienteService.guardar(new PacienteDto("Miguel", "Pelaez", "545515122", new Date(), domicilio));
        //Cuando
        pacienteService.borrarPorId(2L);
        //Entonces
        Assert.assertTrue(!pacienteService.buscarPorId(3L).isPresent());

    }

    @Test
    public void traerTodos() {
        // Dado
        DomicilioDto domicilio = new DomicilioDto("Calle 190", "20", "Usaquen", "Bogotá");
        PacienteDto paciente = pacienteService.guardar(new PacienteDto("Andrea", "Martinez", "95515122", new Date(), domicilio));
        // Cuando
        List<PacienteDto> pacientes = pacienteService.buscarTodos();
        // Entonces
        Assert.assertTrue(!pacientes.isEmpty());
    }

}
