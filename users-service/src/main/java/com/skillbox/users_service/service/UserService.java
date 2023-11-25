package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.User;
import com.skillbox.users_service.entity.UserSkill;
import com.skillbox.users_service.repository.UserRepository;
import com.skillbox.users_service.repository.UserSkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserSkillRepository userSkillRepository;

    public UserService(UserRepository userRepository, UserSkillRepository userSkillRepository) {
        this.userRepository = userRepository;
        this.userSkillRepository = userSkillRepository;
    }

    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User User) {
        return userRepository.save(User);
    }

    public User updateUser(User User, long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return userRepository.save(User);
    }

    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(id);
    }

    public Optional<UserSkill> getUserSkill(long id){
        return userSkillRepository.findById(id);
    }

    public List<UserSkill> getUserSkills(long userId){
        return userSkillRepository.findUserSkillsByUserId(userId);
    }

    public UserSkill addSkill(UserSkill userSkill){
        return userSkillRepository.save(userSkill);
    }

    public void deleteUserSkill(long id) {
        if (!userSkillRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userSkillRepository.deleteById(id);
    }
}
