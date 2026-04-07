package com.example.Cristian_Fernandez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cristian_Fernandez.model.Recursos;
import com.example.Cristian_Fernandez.service.RecursosService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/recursos")
public class RecursosController {
    
    @Autowired
    private RecursosService service;

    @PostMapping
    public ResponseEntity <Recursos> crear(@Valid @RequestBody Recursos recursos) {
        return ResponseEntity.ok(service.crear(recursos));
        
        
    }

    @GetMapping
    public ResponseEntity<List<Recursos>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recursos> obtener(@PathVariable int id){
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Recursos> actualizar(@PathVariable int id, @Valid @RequestBody Recursos recursos){
        return ResponseEntity.ok(service.actualizar(id, recursos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        service.eliminar(id);
        return ResponseEntity.ok("eliminado");
    }
    

    @GetMapping("/ordenados")
    public ResponseEntity<List<Recursos>> ordenado(){
        return ResponseEntity.ok(service.ordenarPorNombre());
    }
    
}
