/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author a_cle
 */
public class PasswordEncoderGenerator {

    public static void main(String[] args) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("Clemente"));

    }

}
