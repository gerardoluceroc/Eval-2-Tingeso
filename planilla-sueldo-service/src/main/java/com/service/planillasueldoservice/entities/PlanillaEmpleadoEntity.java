package com.service.planillasueldoservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planillas_empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanillaEmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_planilla;

    String rut;
    String nombres;
    String categoria;
    int tiempoDeServicio;
    double SueldoFijoMensual;
    double montoBonificacionTiempoServicio;
    double montoPagoHorasExtras;
    double montoDescuentos;
    double sueldoBruto;
    double cotizacionPrevisional;
    double cotizacionSalud;
    double sueldoFinal;

    public Long getId_planilla() {
        return this.id_planilla;
    }

    public void setId_planilla(Long id_planilla) {
        this.id_planilla = id_planilla;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTiempoDeServicio() {
        return this.tiempoDeServicio;
    }

    public void setTiempoDeServicio(int tiempoDeServicio) {
        this.tiempoDeServicio = tiempoDeServicio;
    }

    public double getSueldoFijoMensual() {
        return this.SueldoFijoMensual;
    }

    public void setSueldoFijoMensual(double SueldoFijoMensual) {
        this.SueldoFijoMensual = SueldoFijoMensual;
    }

    public double getMontoBonificacionTiempoServicio() {
        return this.montoBonificacionTiempoServicio;
    }

    public void setMontoBonificacionTiempoServicio(double montoBonificacionTiempoServicio) {
        this.montoBonificacionTiempoServicio = montoBonificacionTiempoServicio;
    }

    public double getMontoPagoHorasExtras() {
        return this.montoPagoHorasExtras;
    }

    public void setMontoPagoHorasExtras(double montoPagoHorasExtras) {
        this.montoPagoHorasExtras = montoPagoHorasExtras;
    }

    public double getMontoDescuentos() {
        return this.montoDescuentos;
    }

    public void setMontoDescuentos(double montoDescuentos) {
        this.montoDescuentos = montoDescuentos;
    }

    public double getSueldoBruto() {
        return this.sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public double getCotizacionPrevisional() {
        return this.cotizacionPrevisional;
    }

    public void setCotizacionPrevisional(double cotizacionPrevisional) {
        this.cotizacionPrevisional = cotizacionPrevisional;
    }

    public double getCotizacionSalud() {
        return this.cotizacionSalud;
    }

    public void setCotizacionSalud(double cotizacionSalud) {
        this.cotizacionSalud = cotizacionSalud;
    }

    public double getSueldoFinal() {
        return this.sueldoFinal;
    }

    public void setSueldoFinal(double sueldoFinal) {
        this.sueldoFinal = sueldoFinal;
    }



    
    
}