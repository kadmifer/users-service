package com.skillbox.users_service.controller;

import com.skillbox.users_service.entity.City;
import com.skillbox.users_service.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    List<City> getCities() {
        return cityService.getCities();
    }

    @GetMapping(path = "/{id}")
    Optional<City> getCity(@PathVariable long id) {
        Optional<City> city = cityService.getCity(id);

        if (city.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return city;
    }

    @PostMapping
    City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping(path = "/{id}")
    City updateCity(@RequestBody City city, @PathVariable long id){
        return cityService.updateCity(city, id);
    }

    @DeleteMapping(path = "/{id}")
    void deleteCity(@PathVariable long id) {
        cityService.deleteCity(id);
    }
}
