/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Educacion;
import com.MiPortfolio.MiPortfolio.service.IEducacionService;
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
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EduController {

    @Autowired
    private IEducacionService eduserv;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/educacion")
    public Educacion agregarEducacion(@RequestBody Educacion edu) {
        return eduserv.crearEducacion(edu);
    }

    @GetMapping("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return eduserv.verEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteedu/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarEducacion(@PathVariable Long id) {
        Educacion e = eduserv.buscarEducacion(id);

        eduserv.borrarEducacion(e);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("editar/edu/{id}")
    public ResponseEntity<Educacion> editarEducacion(@PathVariable Long id,
            @RequestBody Educacion edu) {
        Educacion nuevaEdu = eduserv.buscarEducacion(id);

        nuevaEdu.setInstitucion(edu.getInstitucion());
        nuevaEdu.setTitulo(edu.getTitulo());
        nuevaEdu.setDesde(edu.getDesde());
        nuevaEdu.setHasta(edu.getHasta());
        nuevaEdu.setImg(edu.getImg());

        eduserv.crearEducacion(nuevaEdu);
        return ResponseEntity.ok(nuevaEdu);
    }

    @GetMapping("/buscar/edu/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id) {
        return eduserv.buscarEducacion(id);
    }

}
