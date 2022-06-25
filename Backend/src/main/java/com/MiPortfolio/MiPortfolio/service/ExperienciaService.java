/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.exceptions.ResourceNotFoundException;
import com.MiPortfolio.MiPortfolio.model.Experiencia;
import com.MiPortfolio.MiPortfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository experienciarepo;

    @Override
    public List<Experiencia> verExperiencia() {
       return experienciarepo.findAll();
               }

    @Override
    public Experiencia crearExperiencia(Experiencia experience) {
       return  experienciarepo.save(experience); 
    }

    /*
    @Override
    public void borrarExperiencia(Long id) {
        experienciarepo.deleteById(id);  
    }
*/
    @Override
    public void borrarExperiencia(Experiencia e) {
        experienciarepo.delete(e);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return experienciarepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No existe la experiencia con id: " + id))); 
    }
    
    
}
