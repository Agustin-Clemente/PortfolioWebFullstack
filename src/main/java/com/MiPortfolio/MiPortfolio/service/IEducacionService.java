/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Educacion;
import java.util.List;

/**
 *
 * @author a_cle
 */
public interface IEducacionService {

    public List<Educacion> verEducacion();

    public Educacion crearEducacion(Educacion edu);

    public void borrarEducacion(Educacion edu);

    public Educacion buscarEducacion(Long id);

}
