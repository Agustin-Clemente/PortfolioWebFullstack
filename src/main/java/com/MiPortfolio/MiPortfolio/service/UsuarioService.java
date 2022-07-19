/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Usuario;
import com.MiPortfolio.MiPortfolio.repository.UsuarioRepository;
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
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    public Optional<Usuario> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public void save(Usuario u) {
        userRepo.save(u);
    }

}
