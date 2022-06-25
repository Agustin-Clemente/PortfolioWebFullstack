/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Persona;
import com.MiPortfolio.MiPortfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a_cle
 */

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class Controller {
    
    @Autowired
    private IPersonaService persoserv;
    
    @PostMapping ("/new/persona")
    public String agregarPersona (@RequestBody Persona p){
        persoserv.crearPersona(p);
        return "La persona fue creada correctamente";
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return persoserv.verPersonas();
    }
    
    @DeleteMapping ("/delete/{id}")
    public String borrarPersona (@PathVariable Long id){
        persoserv.borrarPersona(id);
        return "La persona fue borrada correctamente";
    }
    
   
    @PutMapping ("/editar/persona/{id}")
    public Persona editarPersona (@PathVariable Long id,
                                    @RequestParam("nombre") String nuevoNombre,
                                    @RequestParam("apellido") String nuevoApellido,
                                    @RequestParam("img") String nuevaImg,
                                    @RequestParam("acercade") String nuevoacercade,
                                    @RequestParam("profesion") String nuevaprofesion,
                                    @RequestParam("ubicacion") String nuevaubicacion){
    Persona nuevaP = persoserv.buscarPersona(id);
    nuevaP.setNombre(nuevoNombre);
    nuevaP.setApellido(nuevoApellido);
    nuevaP.setImg(nuevaImg);
    nuevaP.setAcercade(nuevoacercade);
    nuevaP.setProfesion(nuevaprofesion);
    nuevaP.setUbicacion(nuevaubicacion);
    
    persoserv.crearPersona(nuevaP);
    return nuevaP; 
}
    
    @GetMapping ("/buscar/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        return persoserv.buscarPersona(id);
    }
}
