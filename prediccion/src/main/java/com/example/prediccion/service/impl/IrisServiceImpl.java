package com.example.prediccion.service.impl;

import com.example.prediccion.entity.Iris;
import com.example.prediccion.service.IrisService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class IrisServiceImpl implements IrisService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public IrisServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public String prediccion(Iris iris) {
        System.out.println("Sending data to Python API: " + iris.toStringIris());
        String url = "http://localhost:5000/predict/iris";
        Map<String, Object> response = restTemplate.postForObject(url, iris, Map.class);
        if (response != null) {
            System.out.println("Received response from Python API: " + response);
            try {
                String formattedResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
                return formattedResponse;
            } catch (Exception e) {
                e.printStackTrace();
                return response.toString();
            }
        } else {
            System.out.println("No response received from Python API");
            return "No response received from Python API";
        }
    }
}