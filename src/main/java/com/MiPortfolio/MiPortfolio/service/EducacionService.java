/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Educacion;
import com.MiPortfolio.MiPortfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository edurepo;

    @Override
    public List<Educacion> verEducacion() {
        return edurepo.findAll();
        }

    @Override
    public Educacion crearEducacion(Educacion edu) {
        return edurepo.save(edu);
                }

    @Override
    public void borrarEducacion(Educacion edu) {
       // edurepo.deleteById(id);
       edurepo.delete(edu);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return edurepo.findById(id).orElse(null);
    }
    
}
