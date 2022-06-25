/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author a_cle
 */
@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    private String acercade;
    
    @NotNull
    private String ubicacion;
    
    @NotNull
    private String profesion;
    
    private String img;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String img, String ubicacion, String profesion, String acercade) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img=img;
        this.acercade = acercade;
        this.profesion = profesion;
        this.ubicacion = ubicacion;
    }
    
    
    
    
    
    
}
