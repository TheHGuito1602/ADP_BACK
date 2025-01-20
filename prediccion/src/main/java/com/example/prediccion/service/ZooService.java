package com.example.prediccion.service;
import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.entity.Zoo;

public interface ZooService {
    public PrediccionResponse prediccion(Zoo zoo);
}
