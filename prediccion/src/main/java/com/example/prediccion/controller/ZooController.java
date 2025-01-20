package com.example.prediccion.controller;

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

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @PostMapping(value="/prediccion", produces = "application/json")
    public ResponseEntity<String> prediccion(@RequestBody Zoo zoo) {
        String response = zooService.prediccion(zoo);
        return ResponseEntity.ok(response);
    }
}