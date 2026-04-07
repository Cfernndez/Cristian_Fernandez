package com.example.Cristian_Fernandez.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
public class Recursos {


    
    private int id;
    @NotBlank ( message ="El nombre es obligatorio")
    private String nombre;

    @NotNull (message = "Debe indicar disponibilidad")
    private Boolean disponible;
    
    @NotBlank ( message ="El responsable es obligatorio")
    private String responsable;

    @NotNull (message = "La fecha es obligatoria")
    private LocalDate fechaCreacion;

    @NotBlank (message = "El tipo es obligatorio")
    private String tipo;

    @Min(value= 1, message = "la cantidad debe ser mayor a 0")
    private int cantidad;

   



}
