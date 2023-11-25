package com.skillbox.users_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="followers_generator")
    @SequenceGenerator(name = "followers_generator", sequenceName = "followers_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "follower_id")
    private Long followerId;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
