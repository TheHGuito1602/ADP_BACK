package com.example.prediccion.service.impl;

import com.example.prediccion.entity.PrediccionResponse;
import org.springframework.stereotype.Service;
import com.example.prediccion.entity.Iris;
import com.example.prediccion.service.IrisService;

@Service
public class IrisServiceImpl implements IrisService {

    @Override
    public PrediccionResponse prediccion(Iris iris) {
        // Lógica de predicción para Iris
        String resultadoPrediccion = "Predicción para Iris: " + iris.toString();
        return new PrediccionResponse(resultadoPrediccion);
    }
}