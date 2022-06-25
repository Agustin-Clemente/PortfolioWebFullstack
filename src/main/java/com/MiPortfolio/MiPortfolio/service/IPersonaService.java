/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Persona;
import java.util.List;

/**
 *
 * @author a_cle
 */
public interface IPersonaService {
    
    public List<Persona> verPersonas ();
    
    public void crearPersona (Persona p);
    
    public void borrarPersona(Long id);
    
    public Persona buscarPersona (Long id);
    
}
