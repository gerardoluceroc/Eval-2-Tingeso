package com.service.marcaentradasalidaservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "marcas_ingreso_salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaIngresoSalidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_marca_ingreso_salida;

    private String hora_entrada;
    private String hora_salida;
    private String fecha;
    private String rut_empleado;

    public Long getId_marca_ingreso_salida() {
        return this.id_marca_ingreso_salida;
    }

    public void setId_marca_ingreso_salida(Long id_marca_ingreso_salida) {
        this.id_marca_ingreso_salida = id_marca_ingreso_salida;
    }

    public String getHora_entrada() {
        return this.hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return this.hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRut_empleado() {
        return this.rut_empleado;
    }

    public void setRut_empleado(String rut_empleado) {
        this.rut_empleado = rut_empleado;
    }


    
    
}