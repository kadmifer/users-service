package com.skillbox.users_service.controller;

import com.skillbox.users_service.entity.Follower;
import com.skillbox.users_service.service.FollowerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/followers")
public class FollowerController {
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService){
        this.followerService = followerService;
    }
}
