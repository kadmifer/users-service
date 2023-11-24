package com.skillbox.users_service.controller;

import com.skillbox.users_service.entity.User;
import com.skillbox.users_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    Optional<User> getUser(@PathVariable long id) {
        Optional<User> user = userService.getUser(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return user;
    }

    @PostMapping
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(path = "/{id}")
    User updateCity(@RequestBody User user, @PathVariable long id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(path = "/{id}")
    void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
