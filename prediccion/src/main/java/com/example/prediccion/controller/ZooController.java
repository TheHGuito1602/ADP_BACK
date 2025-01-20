package com.example.prediccion.controller;

import com.example.prediccion.domain.IrisDomainService;
import com.example.prediccion.domain.ZooDomainService;
import com.example.prediccion.entity.Zoo;
import com.example.prediccion.service.ZooService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
@RestController
@RequestMapping("/zoo")
public class ZooController {
    private final ZooService zooService;
    private final ZooDomainService zooDomainService;
    public ZooController(ZooService zooService, ZooDomainService zooDomainService) {
        this.zooService = zooService;
        this.zooDomainService = zooDomainService;
    }

    @PostMapping(value="/prediccion", produces = "application/json")
    public ResponseEntity<String> prediccion(@RequestBody Zoo zoo) {
        String response = zooService.prediccion(zoo);
        //llamar al domain para que me traiga el porcentaje mas alto y la clase a la que pertenece
        String highestProbabilityClass = zooDomainService.filtrar(response);
        return ResponseEntity.ok(highestProbabilityClass);
    }
}