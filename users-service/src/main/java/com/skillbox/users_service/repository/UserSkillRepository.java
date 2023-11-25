package com.skillbox.users_service.repository;

import com.skillbox.users_service.entity.UserSkill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserSkillRepository extends CrudRepository<UserSkill, Long> {
    List<UserSkill> findAll();
    List<UserSkill> findUserSkillsByUserId(long id);
}
