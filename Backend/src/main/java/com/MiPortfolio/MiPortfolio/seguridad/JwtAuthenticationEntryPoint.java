/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author a_cle
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static Logger logger= LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class );
    
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage()); 
        logger.error("falló el método commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
    
}
