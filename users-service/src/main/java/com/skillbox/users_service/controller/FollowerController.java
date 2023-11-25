package com.skillbox.users_service.controller;

import com.skillbox.users_service.entity.Follower;
import com.skillbox.users_service.service.FollowerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/followers")
public class FollowerController {
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping
    Follower createFollower(@RequestBody Follower follower) {
        return followerService.createFollower(follower);
    }

    @DeleteMapping(path = "/{id}")
    void deleteFollower(@PathVariable long id) {
        followerService.deleteFollower(id);
    }
}
