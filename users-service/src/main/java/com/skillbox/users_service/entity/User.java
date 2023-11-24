package com.skillbox.users_service.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@SQLRestriction("deleted=false")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_generator")
    @SequenceGenerator(name = "users_generator", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "gentder")
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "about")
    private String about;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAbout() {
        return about;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
