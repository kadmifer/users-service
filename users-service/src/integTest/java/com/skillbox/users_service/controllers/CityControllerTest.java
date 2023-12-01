package com.skillbox.users_service.controllers;

import com.skillbox.users_service.containers.PostgresContainerWrapper;
import com.skillbox.users_service.entity.City;
import com.skillbox.users_service.repository.CityRepository;
import com.skillbox.users_service.service.CityService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.springframework.test.context.DynamicPropertySource;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.DynamicPropertyRegistry;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers(disabledWithoutDocker = true)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CityControllerTest {

 /*   @Autowired
    private WebApplicationContext webApplicationContext;
*/
    @Container
    private static final PostgreSQLContainer<PostgresContainerWrapper> postgresContainer = new PostgresContainerWrapper();

    @DynamicPropertySource
    public static void initSystemParams(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkEmptyCityId() throws Exception
    {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/cities/1")
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().is(404));
    }

    @Test
    void createCity() throws Exception
    {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Тестовый город 404\"}")
        );

        resultActions.andExpect(status().is(200));

        ResultActions checkSave = mockMvc.perform(MockMvcRequestBuilders.get("/cities/1")
                .contentType(MediaType.APPLICATION_JSON));

        checkSave.andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.equalTo("Тестовый город 404")));
    }
}