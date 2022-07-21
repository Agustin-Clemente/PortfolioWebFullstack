/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Experiencia;
import com.MiPortfolio.MiPortfolio.service.IExperienciaService;
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
public class ExperienciaController {

    @Autowired
    private IExperienciaService expserv;

    @GetMapping("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return expserv.verExperiencia();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/experiencia")
    public Experiencia agregarExperiencia(@RequestBody Experiencia exp) {
        return expserv.crearExperiencia(exp);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteexp/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarExperiencia(@PathVariable Long id) {
        Experiencia exp = expserv.buscarExperiencia(id);

        expserv.borrarExperiencia(exp);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/exp/{id}")
    public ResponseEntity<Experiencia> editarExperiencia(@PathVariable Long id,
            @RequestBody Experiencia e) {
        Experiencia nuevaExp = expserv.buscarExperiencia(id);

        nuevaExp.setCargo(e.getCargo());
        nuevaExp.setDesde(e.getDesde());
        nuevaExp.setHasta(e.getHasta());
        nuevaExp.setImg(e.getImg());
        nuevaExp.setJornada(e.getJornada());
        nuevaExp.setSector(e.getSector());

        expserv.crearExperiencia(nuevaExp);
        return ResponseEntity.ok(nuevaExp);
    }

    @GetMapping("/buscar/exp/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable Long id) {
        return expserv.buscarExperiencia(id);
    }

}
