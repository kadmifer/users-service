package com.skillbox.users_service.controller;

import com.skillbox.users_service.entity.Skill;
import com.skillbox.users_service.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @GetMapping(path = "/{id}")
    Optional<Skill> getSkill(@PathVariable long id) {
        Optional<Skill> skill = skillService.getSkill(id);

        if (skill.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return skill;
    }

    @PostMapping
    Skill createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping(path = "/{id}")
    Skill updateSkill(@RequestBody Skill skill, @PathVariable long id){
        return skillService.updateSkill(skill, id);
    }

    @DeleteMapping(path = "/{id}")
    void deleteSkill(@PathVariable long id) {
        skillService.deleteSkill(id);
    }
}
