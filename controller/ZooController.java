package unpa.estancias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unpa.estancias.service.ZooService;

@Log4j2
@RestController
@RequestMapping("/zoo")
@RequiredArgsConstructor
public class ZooController {
    private final ZooService zooService;

    @GetMapping
    public String prediccion() {
        return "";
    }

}
