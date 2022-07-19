/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author a_cle
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private long id;

    public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, long id) {
        super(String.format("%s no encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, id));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.id = id;
    }

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
