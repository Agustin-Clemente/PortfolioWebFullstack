/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author a_cle
 */
public class PortfolioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;

    public PortfolioException(HttpStatus estado, String mensaje) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public PortfolioException(HttpStatus estado, String mensaje, String mensaje2) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
        this.mensaje = mensaje2;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
