package com.service.empleadoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name = "categorias_empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_categoria;

    private String tipo_categoria;
    private int sueldo_fijo_mensual;
    private int monto_hora_extra;

    //Getters y Setters de los atributos

    public Long getId_categoria() {
        return this.id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getTipo_categoria() {
        return this.tipo_categoria;
    }

    public void setTipo_categoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }

    public int getSueldo_fijo_mensual() {
        return this.sueldo_fijo_mensual;
    }

    public void setSueldo_fijo_mensual(int sueldo_fijo_mensual) {
        this.sueldo_fijo_mensual = sueldo_fijo_mensual;
    }

    public int getMonto_hora_extra() {
        return this.monto_hora_extra;
    }

    public void setMonto_hora_extra(int monto_hora_extra) {
        this.monto_hora_extra = monto_hora_extra;
    }


    
}

