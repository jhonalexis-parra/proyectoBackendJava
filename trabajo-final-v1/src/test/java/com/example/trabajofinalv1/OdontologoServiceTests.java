package com.example.trabajofinalv1;

import com.example.trabajofinalv1.model.OdontologoDto;
import com.example.trabajofinalv1.service.impl.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
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

    public void cargarDataSet() {
        this.odontologoService.guardar(new OdontologoDto("Santiago", "Paz", "3455647"));

    }

    @Test
    public void agregarOdontologo() {
        this.cargarDataSet();
        OdontologoDto odontologo = odontologoService.guardar(new OdontologoDto("Juan", "Ramirez", "348971960"));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.borrarPorId(1L);
        Assert.assertTrue(!odontologoService.buscarPorId(1L).isPresent());

    }

    @Test
    public void traerTodos() {
        List<OdontologoDto> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }

}
