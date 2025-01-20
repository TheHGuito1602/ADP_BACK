package com.example.prediccion.service.impl;

import com.example.prediccion.entity.PrediccionResponse;
import org.springframework.stereotype.Service;
import com.example.prediccion.entity.Zoo;
import com.example.prediccion.service.ZooService;

@Service
public class ZooServiceImpl implements ZooService {

    @Override
    public PrediccionResponse prediccion(Zoo zoo) {
        // Lógica de predicción para Zoo
        String resultadoPrediccion = "Predicción para Zoo: " + zoo.toString();
        return new PrediccionResponse(resultadoPrediccion);
    }
}