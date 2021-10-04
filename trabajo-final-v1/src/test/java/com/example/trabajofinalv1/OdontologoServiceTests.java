package com.example.trabajofinalv1;

import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {

    @Autowired
    private OdontologoService odontologoService;


    @Test
    public void agregarOdontologo() {
        // Dado
        OdontologoDto odontologo = new OdontologoDto("Jhon", "Parra", "C0001");
        // Cuando
        odontologoService.guardar(odontologo);
        // Entonces
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() {
        // Dado
        OdontologoDto odontologo = new OdontologoDto("Jhon", "Parra", "C0001");
        odontologoService.guardar(odontologo);
        //Cuando
        odontologoService.borrarPorId(1L);
        //Entonces
        Assert.assertTrue(odontologoService.buscarTodos().size() == 1);

    }

    @Test
    public void traerTodos() {
        // Dado
        OdontologoDto odontologo = new OdontologoDto("Jhon", "Parra", "C0001");
        odontologoService.guardar(odontologo);
        // Cuando
        List<OdontologoDto> odontologos = odontologoService.buscarTodos();
        // Entonces
        Assert.assertTrue(odontologos.size() == 2);

    }

}
