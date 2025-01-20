package com.example.prediccion.service.impl;

import com.example.prediccion.entity.Iris;
import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.service.IrisService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IrisServiceImpl implements IrisService {

    private final RestTemplate restTemplate;

    public IrisServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PrediccionResponse prediccion(Iris iris) {
        System.out.println("Sending data to Python API: " + iris);
        String url = "http://localhost:5000/predict/iris";
        PrediccionResponse response = restTemplate.postForObject(url, iris, PrediccionResponse.class);
        if (response != null) {
            System.out.println("Received response from Python API: " + response);
        } else {
            System.out.println("No response received from Python API");
        }
        return response;
    }
}