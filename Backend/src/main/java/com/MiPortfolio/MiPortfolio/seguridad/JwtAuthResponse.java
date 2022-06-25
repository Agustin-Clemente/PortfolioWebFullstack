/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.seguridad;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author a_cle
 */
public class JwtAuthResponse {
    
    private String token;
    private String tipo="Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtAuthResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }
    
    
/*
    public JwtAuthResponse(String token) {
        this.token = token;
    }
*/

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
    
    
    
    
    
    
}
