package com.skillbox.users_service.repository;

import com.skillbox.users_service.entity.Follower;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowerRepository extends CrudRepository<Follower, Long> {
    List<Follower> findAll();
    List<Follower> findAllByFollowerId(long id);
    List<Follower> findAllByUserId(long id);
}
