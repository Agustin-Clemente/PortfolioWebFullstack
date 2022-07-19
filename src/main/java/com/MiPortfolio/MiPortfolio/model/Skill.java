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
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int porcentaje;

    @NotNull
    private String titulo;

    public Skill() {
    }

    public Skill(Long id, int porcentaje, String titulo) {
        this.id = id;
        this.porcentaje = porcentaje;
        this.titulo = titulo;
    }

}
