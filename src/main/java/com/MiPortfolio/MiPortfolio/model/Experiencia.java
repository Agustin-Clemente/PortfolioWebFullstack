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
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String cargo;

    @NotNull
    private String sector;

    @NotNull
    private String jornada;

    @NotNull
    private String desde;

    @NotNull
    private String hasta;

    private String img;

    public Experiencia() {
    }

    public Experiencia(Long id, String cargo, String sector, String img, String jornada, String desde, String hasta) {
        this.id = id;
        this.cargo = cargo;
        this.desde = desde;
        this.hasta = hasta;
        this.jornada = jornada;
        this.sector = sector;
        this.img = img;

    }

}
