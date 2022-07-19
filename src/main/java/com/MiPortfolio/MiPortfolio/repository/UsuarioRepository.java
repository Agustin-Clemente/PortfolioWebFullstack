/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.repository;

import com.MiPortfolio.MiPortfolio.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a_cle
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUsername(String username);

    public Boolean existsByUsername(String username);

}
