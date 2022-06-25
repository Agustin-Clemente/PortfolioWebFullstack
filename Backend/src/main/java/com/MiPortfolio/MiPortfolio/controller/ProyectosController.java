/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Proyectos;
import com.MiPortfolio.MiPortfolio.service.IProyectosService;
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
public class ProyectosController {
    
    @Autowired
    private IProyectosService proyectoserv;
    
    @PostMapping("/new/proyecto")
    @ResponseBody
    public String agregarProyectos (@RequestBody Proyectos p){
        proyectoserv.crearProyectos(p);
        return "El proyecto se agregó correctamente";
    }
    
    @GetMapping ("/ver/proyecto")
    @ResponseBody
    public List<Proyectos> verProyectos(){
        return proyectoserv.verProyectos();
    }
    
    @DeleteMapping ("/deleteproy/{id}")
    public String borrarProyecto(@PathVariable Long id){
        proyectoserv.borrarProyectos(id);
        return "El proyecto fue borrado";
    }
            
    @PutMapping ("/editar/proyecto/{id}")
    public Proyectos editarProyecto (@PathVariable Long id,
                                        @RequestParam ("titulo") String titulo,
                                        @RequestParam ("anio") Integer anio,
                                        @RequestParam ("descripcion") String descripcion,
                                        @RequestParam ("img") String img){
        Proyectos nuevoproy = proyectoserv.buscarProyectos(id);
        
        nuevoproy.setAnio(anio);
        nuevoproy.setDescripcion(descripcion);
        nuevoproy.setImg(img);
        nuevoproy.setTitulo(titulo);
        
        proyectoserv.crearProyectos(nuevoproy);
        return nuevoproy;
    }
    
    @GetMapping ("/buscar/proyecto/{id}")
    @ResponseBody
    public Proyectos buscarProyecto (@PathVariable Long id){
        return proyectoserv.buscarProyectos(id);
    }
            
            
                                        
    
    
}
