package com.example.trabajofinalv1.model;

import com.example.trabajofinalv1.persistence.entities.Odontologo;
import com.example.trabajofinalv1.persistence.entities.Paciente;
import com.example.trabajofinalv1.persistence.entities.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.exception.DataException;

import java.util.Date;

@Getter
@Setter
@ToString
public class TurnoDto {
    private Long id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private Date fechaTurno;

    public TurnoDto() {
    }

    public TurnoDto(OdontologoDto odontologo, PacienteDto paciente, Date fechaTurno) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaTurno = fechaTurno;
    }

    public TurnoDto (Turno t){
        id = t.getId();
        odontologo = new OdontologoDto(t.getOdontologo()) ;
        paciente = new PacienteDto(t.getPaciente());
        fechaTurno = t.getFechaTurno();
    }

    public Turno toEntity(){
        Turno entity = new Turno();

        entity.setId(id);
        entity.setOdontologo(odontologo.toEntity());
        entity.setPaciente(paciente.toEntity());
        entity.setFechaTurno(fechaTurno);

        return entity;
    }


}
