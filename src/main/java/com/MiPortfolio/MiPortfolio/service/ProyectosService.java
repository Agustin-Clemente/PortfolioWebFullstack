/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Proyectos;
import com.MiPortfolio.MiPortfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class ProyectosService implements IProyectosService {

    @Autowired
    public ProyectosRepository proyectorepo;

    @Override
    public List<Proyectos> verProyectos() {
        return proyectorepo.findAll();
    }

    @Override
    public Proyectos crearProyectos(Proyectos p) {
        return proyectorepo.save(p);
    }

    @Override
    public void borrarProyectos(Proyectos p) {
        proyectorepo.delete(p);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyectorepo.findById(id).orElse(null);
    }

}
