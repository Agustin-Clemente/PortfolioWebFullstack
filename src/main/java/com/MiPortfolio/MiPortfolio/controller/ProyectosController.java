/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Proyectos;
import com.MiPortfolio.MiPortfolio.service.IProyectosService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin(origins = "https://miportfolio-b96db.web.app")
public class ProyectosController {

    @Autowired
    private IProyectosService proyectoserv;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/proyecto")
    public Proyectos agregarProyectos(@RequestBody Proyectos p) {
        return proyectoserv.crearProyectos(p);
    }

    @GetMapping("/ver/proyecto")
    @ResponseBody
    public List<Proyectos> verProyectos() {
        return proyectoserv.verProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteproy/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarProyecto(@PathVariable Long id) {
        Proyectos p = proyectoserv.buscarProyectos(id);

        proyectoserv.borrarProyectos(p);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/proyecto/{id}")
    public ResponseEntity<Proyectos> editarProyecto(@PathVariable Long id,
            @RequestBody Proyectos p) {
        Proyectos nuevoproy = proyectoserv.buscarProyectos(id);

        nuevoproy.setAnio(p.getAnio());
        nuevoproy.setDescripcion(p.getDescripcion());
        nuevoproy.setImg(p.getImg());
        nuevoproy.setTitulo(p.getTitulo());

        proyectoserv.crearProyectos(nuevoproy);
        return ResponseEntity.ok(nuevoproy);
    }

    @GetMapping("/buscar/proyecto/{id}")
    @ResponseBody
    public Proyectos buscarProyecto(@PathVariable Long id) {
        return proyectoserv.buscarProyectos(id);
    }

}
