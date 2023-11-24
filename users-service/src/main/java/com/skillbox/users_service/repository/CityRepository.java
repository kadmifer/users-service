package com.skillbox.users_service.repository;

import com.skillbox.users_service.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
