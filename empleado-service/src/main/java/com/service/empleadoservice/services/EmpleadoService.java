package com.service.empleadoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.empleadoservice.entities.CategoriaEmpleadoEntity;
import com.service.empleadoservice.entities.EmpleadoEntity;
import com.service.empleadoservice.repositories.CategoriaEmpleadoRepository;
import com.service.empleadoservice.repositories.EmpleadoRepository;

//import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    CategoriaEmpleadoRepository categoriaEmpleadoRepository;

    
    //Metodo para obtener todos los usuarios en la base de datos
    public ArrayList<EmpleadoEntity> obtenerUsuarios(){

        return ((ArrayList<EmpleadoEntity>) empleadoRepository.findAll());
    }
    

    public ArrayList<EmpleadoEntity> buscarEmpleadoPorId(Long valor_id){

        return empleadoRepository.buscarEmpleadoPorId(valor_id);


    }

    //Metodo para obtener un stirng con la categoria de un empleado
    public String consultarCategoriaEmpleado(EmpleadoEntity empleado){
        CategoriaEmpleadoEntity categoria = categoriaEmpleadoRepository.buscarCategoriaById(empleado.getId_empleado());
        
        String categoriaString = categoria.getTipo_categoria();
        return categoriaString;
    }
    




    



    //Metodo para calcular el descuento por prevision social de un empleado
    public static double calcularDescuentoCotizacionPrevisional(EmpleadoEntity empleado){

        //Porcentaje que se descuento por cotizacion previsional
        double porcentajeCotizacionPrevisional = 0.1;

        //Se obtiene el sueldo fijo mensual del empleado de acuerdo a su categoría
        int sueldoFijoMensual = empleado.getCategoria().getSueldo_fijo_mensual();

        //descuento total del sueldo fijo mensual para cotizacion previsional
        double descuentoCotizacionPrevisional = sueldoFijoMensual * porcentajeCotizacionPrevisional;

        return descuentoCotizacionPrevisional;

    }//Fin calcularDescuentoCotizacionSocial()

     //Metodo para calcular el descuento por la cotizacion del plan de salud de un empleado
     public static double calcularDescuentoCotizacionPlanSalud(EmpleadoEntity empleado){

        //Porcentaje que se descuenta por cotización del plan de salud
        double porcentajeCotizacionPlanSalud = 0.08;

        //Se obtiene el sueldo fijo mensual del empleado de acuerdo a su categoría
        int sueldoFijoMensual = empleado.getCategoria().getSueldo_fijo_mensual();

        //descuento total del sueldo fijo mensual para cotizacion previsional
        double descuentoCotizacionPlanSalud = sueldoFijoMensual * porcentajeCotizacionPlanSalud;

        return descuentoCotizacionPlanSalud;

    }//Fin calcularDescuentoCotizacionPlanSalud()

    /* 
    //Metodo para calcular el descuento por inasistencias de un empleado
    public double calcularDescuentoInasistenciasNoJustificadas(EmpleadoEntity empleado){

        int cantidadInasistencias = empleadoRepository.calcularInasistenciasNoJustificadas(empleado.getId_empleado());
        double porcentajeDescuentoPorDia = 0.15;
        double porcentajeDescuentoTotal = porcentajeDescuentoPorDia * cantidadInasistencias;

        int sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());
        double descuentoTotal = sueldoFijo * porcentajeDescuentoTotal;

        //System.out.println("Cantidad de inasistencias: "+cantidadInasistencias);
        //System.out.println("Sueldo Fijo: "+sueldoFijo);


        return 0;//no se usara esta función por lo que retornará cero por ahora
    }//fin calcularDescuentoInasistencias
*/


    //Método para calcular la cantidad de años que lleva un empleado
    public int calcularYearsOfService(EmpleadoEntity empleado){

        //se guarda la fecha de ingreso del empleado
        Date fechaIngreso = empleado.getFecha_ingreso();

        //Se guarda la cantidad de dias que contiene un año
        double daysPerYear = 365.25;

        Date fechaHoy = new Date();

        //Se calculan los milisegundos transcurridos entre la fecha actual y la fecha de ingreso del empleado
        long tiempoTranscurrido = fechaHoy.getTime() - fechaIngreso.getTime();

        //Se obtienen los dias transcurridos
        TimeUnit unidadMedida = TimeUnit.DAYS;
        long diasTranscurridos = unidadMedida.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        
        //Se calculan los años de servicio (int)
        Double calculoYears = diasTranscurridos / daysPerYear;
        int yearsService = calculoYears.intValue();

        return yearsService;



    }//fin calcularYearsOfService

    //Metodo para calcular la bonificacion de un empleado por años de servicio
    public double calcularBonificacionTiempoServicio(EmpleadoEntity empleado){

        double BonificationLessThanFive = 0.0;
        double BonificationMoreThanFive = 0.05;
        double BonificationMoreThanTen = 0.08;
        double BonificationMoreThanFiveteen = 0.11;
        double BonificationMoreThanTwenty = 0.14;
        double BonificationMoreThanTwentyfive = 0.17;

        //salida
        double bonificacionTotal = 0;

        //Se obtiene la cantidad de años de servicio del empleado
        int yearsService = calcularYearsOfService(empleado);


        //Se calcula la bonificación de acuerdo a los años de servicio y se retorna su resultado
        double sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());

        if(yearsService < 5 ){
            bonificacionTotal = sueldoFijo * BonificationLessThanFive;
            return bonificacionTotal;

        }else if((yearsService >= 5) && (yearsService < 10)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanFive;
            return bonificacionTotal;

        }else if((yearsService >= 10) && (yearsService < 15)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTen; 
            return bonificacionTotal;          

        }else if((yearsService >= 15) && (yearsService < 20)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanFiveteen;
            return bonificacionTotal;

        }else if((yearsService >= 20) && (yearsService < 25)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTwenty;
            return bonificacionTotal;

        }else if(yearsService >= 25){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTwentyfive;
            return bonificacionTotal;
        }else {
            return bonificacionTotal;
        }
        
    }// fin calcular bonificacion por tiempo de servicio

    //Metodo que obtiene el sueldo fijo mensual de un empleado
    public double getSueldo_fijo_mensual(EmpleadoEntity empleado){

        double sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());
        return sueldoFijo;
    }

    public double calcularBonificacionHorasExtras(EmpleadoEntity empleado){
        return 0;
    }

    public double calcularDescuentosTotales(EmpleadoEntity empleado){

        double descuentoCotizacionPlanSalud = calcularDescuentoCotizacionPlanSalud(empleado);
        double descuentoCotizacionPrevisional = calcularDescuentoCotizacionPrevisional(empleado);
        //double descuentoInasistencias = calcularDescuentoInasistenciasNoJustificadas(empleado);
        double descuentoAtrasos = 0;
        
        double descuentos = descuentoCotizacionPlanSalud + descuentoCotizacionPrevisional + descuentoAtrasos;
        return descuentos;
    }

    public double calcularBonificacionTotal(EmpleadoEntity empleado){
        double bonificacionTotal;
        double bonificacionTiempoServicio = calcularBonificacionHorasExtras(empleado);
        double bonificacionHorasExtras = calcularBonificacionHorasExtras(empleado);

        bonificacionTotal = bonificacionTiempoServicio + bonificacionHorasExtras;
        return bonificacionTotal;
    }
   
    public double calcularSueldoBruto(EmpleadoEntity empleado){


        //se asume que el sueldo bruto es: sueldo mensual - descuentos + bonos

        double sueldoBruto;
        double descuentos = calcularDescuentosTotales(empleado);
        double sueldoFijoMensual = getSueldo_fijo_mensual(empleado);
        double bonificaciones = calcularBonificacionTotal(empleado);

        sueldoBruto = sueldoFijoMensual + bonificaciones - descuentos;
        if(sueldoBruto<0){
            return 0;
        }else{return sueldoBruto;}

    }

    //Metodo para calcular el sueldo final de un empleado
    public double calcularSueldoFinal(EmpleadoEntity empleado){
        //se asume que el sueldo final es: sueldo fijo - descuentos

        double sueldoFinal;
        double descuentos = calcularDescuentosTotales(empleado);
        double sueldoFijoMensual = getSueldo_fijo_mensual(empleado);
        sueldoFinal = sueldoFijoMensual - descuentos;
        
        if(sueldoFinal < 0){
            return 0;
        }else{return sueldoFinal;}


    }








  
    
    

}