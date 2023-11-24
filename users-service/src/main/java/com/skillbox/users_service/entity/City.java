package com.skillbox.users_service.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "cities")
@SQLDelete(sql = "UPDATE cities SET deleted = true WHERE id=?")
@SQLRestriction("deleted=false")
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cities_generator")
    @SequenceGenerator(name = "cities_generator", sequenceName = "cities_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public City() {
    }

    public City(String title) {
        this.title = title;
    }

    public City(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
