package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.Follower;
import com.skillbox.users_service.repository.FollowerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository  followerRepository){
        this.followerRepository = followerRepository;
    }

    public List<Follower> getFollowers(long id) {
        return followerRepository.findAllByUserId(id);
    }

    public List<Follower> getUsers(long id) {
        return followerRepository.findAllByFollowerId(id);
    }

    public Follower createFollower(Follower follower) {
        return followerRepository.save(follower);
    }

    public void deleteFollower(long id) {
        if (!followerRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        followerRepository.deleteById(id);
    }
}
