/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Persona;
import com.MiPortfolio.MiPortfolio.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persorepo;
    
    
    @Override
    public List<Persona> verPersonas() {
       return persorepo.findAll();
    }

    @Override
    public void crearPersona(Persona p) {
        persorepo.save(p);
    }

    @Override
    public void borrarPersona(Long id) {
       persorepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persorepo.findById(id).orElse(null);
    }
    
}
