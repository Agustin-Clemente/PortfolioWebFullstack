/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Proyectos;
import java.util.List;

/**
 *
 * @author a_cle
 */
public interface IProyectosService {
    
    public List<Proyectos> verProyectos();
    
    public void crearProyectos(Proyectos p);
    
    public void borrarProyectos(Long id);
    
    public Proyectos buscarProyectos (Long id);
    
}
