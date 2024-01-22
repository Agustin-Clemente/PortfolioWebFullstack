/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.exceptions.Mensaje;
import com.MiPortfolio.MiPortfolio.model.Login;
import com.MiPortfolio.MiPortfolio.seguridad.JwtAuthResponse;
import com.MiPortfolio.MiPortfolio.seguridad.JwtTokenProvider;
import com.MiPortfolio.MiPortfolio.service.RolService;
import com.MiPortfolio.MiPortfolio.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a_cle
 */
@RestController
@RequestMapping("/auth")
//@CrossOrigin
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UsuarioService userServ;

    @Autowired
    RolService rolServ;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@Valid @RequestBody Login login, BindingResult binding) {
        if (binding.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos mal ingresados"), HttpStatus.BAD_REQUEST);
        }

        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = tokenProvider.generarToken(auth);

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        JwtAuthResponse jwt = new JwtAuthResponse(token, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwt, HttpStatus.OK);
    }

}
