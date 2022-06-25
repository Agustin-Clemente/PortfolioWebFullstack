/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author a_cle
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final static Logger logger= LoggerFactory.getLogger(JwtAuthenticationFilter.class );
    
    
    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private CustomUserDetailsService userDetailsServ;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getJWT(request);
            if(token !=null && tokenProvider.validarToken(token)){
                 String username= tokenProvider.obtenerUsernameDeJWT(token);
                 UserDetails userDetails = userDetailsServ.loadUserByUsername(username);
                 UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            
                 SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            logger.error("Fallo en el doFilter");
        }
        
        filterChain.doFilter(request, response);
    }
    
     private String getJWT(HttpServletRequest request){
        String header= request.getHeader("Authorization");
        if(header !=null && header.startsWith("Bearer"))
            return header.replace("Bearer ", "");
        return null;
    }

    /*
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJWT(request);
        
        if(StringUtils.hasText(token) && tokenProvider.validarToken(token)){
            String username= tokenProvider.obtenerUsernameDeJWT(token);
            
            //cargamos usuario
            UserDetails userDetails = userDetailsServ.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            
            //establecemos la seguridad
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        filterChain.doFilter(request, response);
    }
    */
   
    
    /*
    private String getJWT(HttpServletRequest request){
        String bearerToken= request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken)&& bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }
    */
    
}
