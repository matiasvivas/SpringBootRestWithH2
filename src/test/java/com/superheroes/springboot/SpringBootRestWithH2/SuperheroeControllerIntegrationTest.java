package com.superheroes.springboot.SpringBootRestWithH2;

import com.superheroes.springboot.SpringBootRestWithH2.model.Superheroe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SuperheroeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSuperheroe()
    {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/superheroe/1", Superheroe.class)
                        .getId().equals(1));
    }

    @Test
    public void testAllSuperheroe() {
        assertTrue(
                this.restTemplate
                        .getForObject("http://localhost:" + port + "/superheroes", List.class).size() == 2);
    }
}

