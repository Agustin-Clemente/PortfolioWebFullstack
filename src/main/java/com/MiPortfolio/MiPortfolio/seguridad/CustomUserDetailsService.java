/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import com.MiPortfolio.MiPortfolio.model.Usuario;
import com.MiPortfolio.MiPortfolio.model.UsuarioPrincipal;
import com.MiPortfolio.MiPortfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService userServ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = userServ.getByUsername(username).get();

        return UsuarioPrincipal.build(u);
    }
}
