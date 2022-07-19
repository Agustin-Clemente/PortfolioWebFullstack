/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import com.MiPortfolio.MiPortfolio.model.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author a_cle
 */
@Component
public class JwtTokenProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${jwt-secret}")
    private String llaveSecreta;

    @Value("${jwt-expiration}")
    private int jwtExpiration;

    public String generarToken(Authentication auth) {
        UsuarioPrincipal usuarioPpal = (UsuarioPrincipal) auth.getPrincipal();

        String token = Jwts.builder().setSubject(usuarioPpal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, llaveSecreta).compact();

        return token;

    }

    public String obtenerUsernameDeJWT(String token) {
        return Jwts.parser().setSigningKey(llaveSecreta).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(llaveSecreta).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Firma de JWT no válida");
        } catch (MalformedJwtException e) {
            logger.error("Token no válido");
        } catch (ExpiredJwtException e) {
            logger.error("El token ha caducado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no compatible");
        } catch (IllegalArgumentException e) {
            logger.error("La cadena claims está vacia");
        }
        return false;
    }

}
