package com.example.prediccion.controller;

import com.example.prediccion.entity.PrediccionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.prediccion.service.IrisService;

@Log4j2
@RestController
@RequestMapping("/iris")
@RequiredArgsConstructor
public class IrisController {
    private final IrisService irisService;

    @GetMapping("/prediccion")
    public ResponseEntity<PrediccionResponse> prediccion() {
        PrediccionResponse response = new PrediccionResponse("Predicción exitosa");
        return ResponseEntity.ok(response);
    }
}
