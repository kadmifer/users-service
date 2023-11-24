package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.User;
import com.skillbox.users_service.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
