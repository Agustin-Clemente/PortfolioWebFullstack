/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.controller;

import com.MiPortfolio.MiPortfolio.model.Skill;
import com.MiPortfolio.MiPortfolio.service.ISkillService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a_cle
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    @Autowired
    private ISkillService skillService;

    @GetMapping("/ver/skills")
    @ResponseBody
    public List<Skill> traerSkills() {
        return skillService.traerSkills();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/skill")
    public Skill crearSkill(@RequestBody Skill s) {
        return skillService.crearSkill(s);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-skill/{id}")
    public ResponseEntity<Map<String, Boolean>> borrarSkill(@PathVariable Long id) {
        Skill s = skillService.buscarSkill(id);

        skillService.borrarSkill(s);

        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/skill/{id}")
    public ResponseEntity<Skill> editarSkill(@PathVariable Long id,
            @RequestBody Skill s) {
        Skill nuevaSkill = skillService.buscarSkill(id);

        nuevaSkill.setPorcentaje(s.getPorcentaje());
        nuevaSkill.setTitulo(s.getTitulo());

        skillService.crearSkill(nuevaSkill);
        return ResponseEntity.ok(nuevaSkill);

    }

    @GetMapping("/buscar/skill/{id}")
    @ResponseBody
    public Skill buscarSkill(@PathVariable Long id) {
        return skillService.buscarSkill(id);
    }

}
