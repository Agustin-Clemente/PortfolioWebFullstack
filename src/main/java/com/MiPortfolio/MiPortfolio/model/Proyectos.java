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
@Getter
@Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private Integer anio;

    @NotNull
    private String descripcion;

    private String img;

    public Proyectos() {
    }

    public Proyectos(Long id, String titulo, String descripcion, String img, Integer anio) {
        this.id = id;
        this.anio = anio;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.img = img;

    }

}
