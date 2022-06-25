/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Rol;
import com.MiPortfolio.MiPortfolio.repository.RolRepository;
import com.MiPortfolio.MiPortfolio.seguridad.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepo;
    
    public Optional<Rol> getByRol(RolNombre rol){
        return rolRepo.findByRol(rol);
    }
    
}
