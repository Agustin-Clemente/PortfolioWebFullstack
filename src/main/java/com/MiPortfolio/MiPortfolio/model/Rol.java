/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.model;

import com.MiPortfolio.MiPortfolio.seguridad.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String nombre;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rol;

    public Rol() {
    }

    public Rol(RolNombre rol) {
        this.rol = rol;
    }

}
