/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author a_cle
 */
public interface IExperienciaService {
    
    public List<Experiencia> verExperiencia();
    
    public Experiencia crearExperiencia(Experiencia experience);
    
    public void borrarExperiencia (Experiencia e);
    //public void borrarExperiencia (Long id);

public Experiencia buscarExperiencia (Long id);    
    
    
    
    
    
    
}
