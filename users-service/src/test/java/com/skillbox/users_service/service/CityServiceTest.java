package com.skillbox.users_service.service;

import com.skillbox.users_service.entity.City;
import com.skillbox.users_service.repository.CityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    @Test
    void createCity() {
        //given
        CityRepository cityRepository = Mockito.mock(CityRepository.class);
        City city = new City("Москва");
        City savedCity = new City(1L, "Москва");
        Mockito.when(cityRepository.save(city)).thenReturn(savedCity);
        CityService cityService = new CityService(cityRepository);
        //when
        City result = cityService.createCity(city);
        //then
        Assertions.assertEquals(1L, result.getId());
    }

    @Test
    void updateCity() {
        //given
        CityRepository cityRepository = Mockito.mock(CityRepository.class);
        City city = new City(1L,"Москва");
        City savedCity = new City(1L, "Москва Тест");

        Mockito.when(cityRepository.save(city)).thenReturn(savedCity);
        Mockito.when(cityRepository.existsById(1L)).thenReturn(true);

        CityService cityService = new CityService(cityRepository);
        //when
        City result = cityService.updateCity(city, 1L);
        //then
        Assertions.assertEquals("Москва Тест", result.getTitle());
    }
}