package com.service.empleadoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.empleadoservice.entities.CategoriaEmpleadoEntity;
import com.service.empleadoservice.repositories.CategoriaEmpleadoRepository;


@Service
public class CategoriaEmpleadoService {

    @Autowired
    CategoriaEmpleadoRepository categoriaEmpleadoRepository;

    //Metodo para obtener una categoría de empleado por medio de la id de la categoria
    public CategoriaEmpleadoEntity obtenerCategoria(CategoriaEmpleadoEntity categoria){

        return categoriaEmpleadoRepository.buscarCategoriaById(categoria.getId_categoria());
    }
    
}
