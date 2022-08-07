package com.example.RestDataJPA.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Podemos crear un test para probar en nuestra api corriendo en el puerto por default
 * Si haci lo quisieramos debemos descometar las líneas y comentar las que estan para ejecutar
 */
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //Comentar para usar puerto 8080
class HelloControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort //Comentar para usar puerto 8080
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port); //Comentar para usar puerto 8080
//        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:8080");
        testRestTemplate =  new TestRestTemplate(restTemplateBuilder);
    }

    @Value("${app.message}")
    String message;

    @Test
    void hello() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/hello", String.class);

        assertEquals(message, response.getBody() );
        assertEquals(200, response.getStatusCodeValue() );
    }
}