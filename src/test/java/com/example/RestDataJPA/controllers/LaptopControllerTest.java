package com.example.RestDataJPA.controllers;

import com.example.RestDataJPA.entities.Laptop;
import com.example.RestDataJPA.repository.LaptopRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Los test seran más completos con el curso de Junit
 * estos son solo una introducción
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    //SetUp Antes de cada método
    //BeforeClass Antes de toda la clase(LaptopControllerTest o de la que se invoque)

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port );
        testRestTemplate =  new TestRestTemplate(restTemplateBuilder);

    }

    @Test
    @Order(1)
    void create(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON );
        headers.setAccept( Arrays.asList(MediaType.APPLICATION_JSON) );


        String body = """
                {
                    "marca": "Lenovo2",
                    "modelo": "BBB2",
                    "price": 200000
                }
                """;
        HttpEntity request = new HttpEntity<>(body,headers);

        ResponseEntity<Laptop> response = testRestTemplate.postForEntity("/api/laptop", request, Laptop.class);
        Laptop responseBody = response.getBody();
        Long id = responseBody.getId();

        assertEquals("Lenovo2", responseBody.getMarca() );
    }

    @Test
    @Order(2)
    void findAll() {

        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        List<Laptop> laptops = Arrays.asList( response.getBody() );
        System.out.println( laptops );

        //Deberia haber dos datos, ya que son los cargados manualmente desde
        //@BeforeAll
        assertEquals( 1 , laptops.size()  );
    }






}