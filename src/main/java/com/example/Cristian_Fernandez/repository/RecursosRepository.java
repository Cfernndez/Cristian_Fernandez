package com.example.Cristian_Fernandez.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.Cristian_Fernandez.model.Recursos;

@Repository
public class RecursosRepository {
    
    private List<Recursos> lista= new ArrayList<>();
    private int contador = 1;
    
    public Recursos guardar(Recursos recurso){
        recurso.setId(contador++);
        lista.add(recurso);
        return recurso;
    }

    public List<Recursos> obtenerTodos(){
        return lista;
    }

    public Optional<Recursos> buscarPorId(int id){
        return lista.stream()
                .filter(r -> r.getId()==id )
                .findFirst();
    }

    public void eliminar(int id){
        lista.removeIf(r -> r.getId()== id);
    }
}
