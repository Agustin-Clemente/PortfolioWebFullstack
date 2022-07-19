/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.exceptions.ResourceNotFoundException;
import com.MiPortfolio.MiPortfolio.model.Skill;
import com.MiPortfolio.MiPortfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author a_cle
 */
@Service
public class SkillService implements ISkillService {

    @Autowired
    public SkillRepository skillRepo;

    @Override
    public List<Skill> traerSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Skill crearSkill(Skill s) {
        return skillRepo.save(s);
    }

    @Override
    public void borrarSkill(Skill s) {
        skillRepo.delete(s);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skillRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No existe la skill con id: " + id)));
    }

}
