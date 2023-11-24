package com.skillbox.users_service.repository;

import com.skillbox.users_service.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
