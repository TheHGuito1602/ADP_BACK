package com.example.prediccion.service.impl;

import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.entity.Zoo;
import com.example.prediccion.service.ZooService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class ZooServiceImpl implements ZooService {

    private final RestTemplate restTemplate;

    public ZooServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PrediccionResponse prediccion(Zoo zoo) {
        System.out.println("Datos enviados "+zoo.toStringZoo());
        String url = "http://localhost:5000/predict/animals";
        return restTemplate.postForObject(url, zoo, PrediccionResponse.class);
    }
}