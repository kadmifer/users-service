package com.skillbox.users_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_skills")
public class UserSkill {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_skills_generator")
    @SequenceGenerator(name = "user_skills_generator", sequenceName = "user_skills_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "skillId")
    private Long skillId;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
}
