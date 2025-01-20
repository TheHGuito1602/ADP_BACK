package unpa.estancias.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unpa.estancias.service.IrisService;

@Log4j2
@RestController
@RequestMapping("/iris")
@RequiredArgsConstructor
public class IrisController {
    private final IrisService irisService;

    @GetMapping("/prediccion")
    public String prediccion() {
        return "";
    }

}
