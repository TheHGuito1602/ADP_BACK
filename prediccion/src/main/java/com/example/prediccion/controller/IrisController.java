package com.example.prediccion.controller;

import com.example.prediccion.domain.IrisDomainService;
import com.example.prediccion.entity.Iris;
import com.example.prediccion.service.IrisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/iris")
public class IrisController {
    private final IrisService irisService;
    private final IrisDomainService irisDomainService;

    public IrisController(IrisService irisService, IrisDomainService irisDomainService) {
        this.irisService = irisService;
        this.irisDomainService = irisDomainService;
    }

    @PostMapping(value = "/prediccion", produces = "application/json")
    public ResponseEntity<String> prediccion(@RequestBody Iris iris) {
        String response = irisService.prediccion(iris);
        // Call the domain service to get the highest probability class
        String highestProbabilityClass = irisDomainService.filtrar(response);

        return ResponseEntity.ok(highestProbabilityClass);
    }
}