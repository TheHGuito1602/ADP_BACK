package com.example.prediccion.controller;

import com.example.prediccion.entity.Iris;
import com.example.prediccion.entity.PrediccionResponse;
import com.example.prediccion.service.IrisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
@RestController
@RequestMapping("/iris")
@RequiredArgsConstructor
public class IrisController {
    private final IrisService irisService;

    @PostMapping("/prediccion")
    public ResponseEntity<PrediccionResponse> prediccion(@RequestBody Iris iris) {
        PrediccionResponse response = irisService.prediccion(iris);
        return ResponseEntity.ok(response);
    }
}