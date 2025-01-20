package com.example.prediccion.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Iris implements Serializable {
    @JsonProperty("a1")
    private float a1;
    @JsonProperty("a2")
    private float a2;
    @JsonProperty("a3")
    private float a3;
    @JsonProperty("a4")
    private float a4;

    public String toStringIris(){
        return "Iris{" +
                "a1=" + a1 +
                ", a2=" + a2 +
                ", a3=" + a3 +
                ", a4=" + a4 +
                '}';
    }
}
