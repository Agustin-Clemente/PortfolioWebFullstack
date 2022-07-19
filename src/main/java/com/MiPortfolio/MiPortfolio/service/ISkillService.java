/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MiPortfolio.MiPortfolio.service;

import com.MiPortfolio.MiPortfolio.model.Skill;
import java.util.List;

/**
 *
 * @author a_cle
 */
public interface ISkillService {

    public List<Skill> traerSkills();

    public Skill crearSkill(Skill s);

    public void borrarSkill(Skill s);

    public Skill buscarSkill(Long id);

}
