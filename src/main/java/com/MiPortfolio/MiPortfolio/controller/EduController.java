/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Educacion;
import com.MiPortfolio.MiPortfolio.service.IEducacionService;
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
public class EduController {
    
    @Autowired
    private IEducacionService eduserv;
    
     @PostMapping ("/new/educacion")
     public String agregarEducacion (@RequestBody Educacion edu){
             eduserv.crearEducacion(edu);
             return "La educación se creo correctamente";
                     }
     
     @GetMapping ("/ver/educacion")
     @ResponseBody
     public List<Educacion> verEducacion(){
    return eduserv.verEducacion();
     }
     
     @DeleteMapping ("/deleteedu/{id}")
     public String borrarEducacion (@PathVariable Long id){
         eduserv.borrarEducacion(id);
         return "La educación fue borrada";
     }
     
      @PutMapping ("editar/edu/{id}")
      public Educacion editarEducacion (@PathVariable Long id,
                                        @RequestParam ("institucion") String institucion,
                                        @RequestParam ("titulo") String titulo,
                                        @RequestParam ("desde") String desde,
                                        @RequestParam ("hasta") String hasta,
                                        @RequestParam ("img") String img){
          
          Educacion nuevaEdu = eduserv.buscarEducacion(id);
          nuevaEdu.setTitulo(titulo);
          nuevaEdu.setInstitucion(institucion);
          nuevaEdu.setDesde(desde);
          nuevaEdu.setHasta(hasta);
          nuevaEdu.setImg(img);
          
          eduserv.crearEducacion(nuevaEdu);
                  return nuevaEdu;
      }
      
      @GetMapping ("/buscar/edu/{id}")
      @ResponseBody
      public Educacion buscarEducacion (@PathVariable Long id){
          return eduserv.buscarEducacion(id);
      }
     
    
}
