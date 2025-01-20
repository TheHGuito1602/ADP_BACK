package com.example.prediccion.controller;

import com.example.prediccion.entity.Iris;
import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.service.IrisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/iris")
public class IrisController {
    private final IrisService irisService;

    public IrisController(IrisService irisService) {
        this.irisService = irisService;
    }

    @PostMapping(value = "/prediccion", produces = "application/json")
    public ResponseEntity<PrediccionResponse> prediccion(@RequestBody Iris iris) {
        PrediccionResponse response = irisService.prediccion(iris);
        return ResponseEntity.ok(response);
    }
}