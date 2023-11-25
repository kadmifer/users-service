package com.skillbox.users_service.repository;

import com.skillbox.users_service.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    List<Skill> findAll();
}
