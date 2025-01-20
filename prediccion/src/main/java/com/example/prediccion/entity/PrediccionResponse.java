package com.example.prediccion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrediccionResponse {
    @JsonProperty("prediction")
    private String prediccion;
}
