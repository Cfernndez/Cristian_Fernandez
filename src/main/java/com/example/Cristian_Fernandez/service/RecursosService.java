package com.example.Cristian_Fernandez.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Cristian_Fernandez.model.Recursos;
import com.example.Cristian_Fernandez.repository.RecursosRepository;

@Service
public class RecursosService {
    @Autowired
    private RecursosRepository repository;
    

    public Recursos crear(Recursos recursos){
        return repository.guardar(recursos);

    }

    public List<Recursos> listar(){
        return repository.obtenerTodos();

    }

    public Recursos obtenerPorId(int id){
        return repository.buscarPorId(id)
        .orElseThrow(() -> new RuntimeException("Recurso no encontrado"));

    }

    public Recursos actualizar(int id, Recursos nuevo){
        Recursos r = obtenerPorId(id);
        
        r.setNombre(nuevo.getNombre());
        r.setResponsable(nuevo.getResponsable());
        r.setDisponible(nuevo.getDisponible());
        r.setFechaCreacion(nuevo.getFechaCreacion());
        r.setTipo(nuevo.getTipo());
        r.setCantidad(nuevo.getCantidad());


        return r;
    }


    public void eliminar(int id){
        obtenerPorId(id);
        repository.eliminar(id);
    }

    public List<Recursos> ordenarPorNombre(){
            List<Recursos> lista = repository.obtenerTodos();
            lista.sort(Comparator.comparing(Recursos::getNombre));
            return lista;
    }


}
