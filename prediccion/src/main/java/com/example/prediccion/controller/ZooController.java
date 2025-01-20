package com.example.prediccion.controller;

import com.example.prediccion.entity.Zoo;
import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.service.ZooService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
@RestController
@RequestMapping("/zoo")
@RequiredArgsConstructor
public class ZooController {
    private final ZooService zooService;

    @PostMapping("/prediccion")
    public ResponseEntity<PrediccionResponse> prediccion(@RequestBody Zoo zoo) {
        PrediccionResponse response = zooService.prediccion(zoo);
        return ResponseEntity.ok(response);
    }
}