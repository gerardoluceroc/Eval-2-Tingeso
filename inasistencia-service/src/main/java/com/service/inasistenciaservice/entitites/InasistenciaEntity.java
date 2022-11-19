package com.service.inasistenciaservice.entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;

@Entity
@Table(name = "inasistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InasistenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_inasistencia;

    private String fecha;
    private boolean justificativoAprobado;
    private String rutEmpleado;
    private String motivoInasistencia;


    public Long getId_inasistencia() {
        return this.id_inasistencia;
    }

    public void setId_inasistencia(Long id_inasistencia) {
        this.id_inasistencia = id_inasistencia;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isJustificativoAprobado() {
        return this.justificativoAprobado;
    }

    public boolean getJustificativoAprobado() {
        return this.justificativoAprobado;
    }

    public void setJustificativoAprobado(boolean justificativoAprobado) {
        this.justificativoAprobado = justificativoAprobado;
    }

    public String getRutEmpleado() {
        return this.rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getMotivoInasistencia() {
        return this.motivoInasistencia;
    }

    public void setMotivoInasistencia(String motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
    }


    

    
    
}