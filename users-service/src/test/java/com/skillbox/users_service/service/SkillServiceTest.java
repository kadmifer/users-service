package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.Skill;
import com.skillbox.users_service.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SkillServiceTest {

    @Test
    void createSkill() {
        SkillRepository skillRepository = Mockito.mock(SkillRepository.class);
        Skill skill = new Skill("Программирование");
        Skill saveSkill = new Skill(1L, "Программирование");
        Mockito.when(skillRepository.save(skill)).thenReturn(saveSkill);
        SkillService skillService = new SkillService(skillRepository);
        
        Skill result = skillService.createSkill(skill);

        Assertions.assertEquals(1L, result.getId());
    }

    @Test
    void updateSkill() {
        SkillRepository skillRepository = Mockito.mock(SkillRepository.class);
        Skill skill = new Skill("Программирование");
        Skill saveSkill = new Skill(1L, "Программирование Java");
        Mockito.when(skillRepository.save(skill)).thenReturn(saveSkill);
        Mockito.when(skillRepository.existsById(1L)).thenReturn(true);

        SkillService skillService = new SkillService(skillRepository);

        Skill result = skillService.updateSkill(skill, 1L);

        Assertions.assertEquals("Программирование Java", result.getTitle());
    }
}