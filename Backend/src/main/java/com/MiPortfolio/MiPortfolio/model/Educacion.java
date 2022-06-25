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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    private String institucion;
    
    @NotNull
    private String titulo;
    
    @NotNull
    private String desde;
    
    @NotNull
    private String hasta;
    
    private String img;

    public Educacion() {
    }

    public Educacion(Long id, String institucion, String titulo, String img, String desde, String hasta) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.institucion = institucion;
        this.titulo = titulo;
        this.img=img;
        
    }
    
}
