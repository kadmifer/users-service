package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.Skill;
import com.skillbox.users_service.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Optional<Skill> getSkill(long id) {
        return skillRepository.findById(id);
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill createSkill(Skill city) {
        return skillRepository.save(city);
    }

    public Skill updateSkill(Skill city, long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return skillRepository.save(city);
    }

    public void deleteSkill(long id) {
        if (!skillRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        skillRepository.deleteById(id);
    }
}
